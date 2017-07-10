package szu.whale.wenote.api.subscriber;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.HttpException;
import rx.Subscriber;
import szu.whale.wenote.api.basic.NetworkException;
import szu.whale.wenote.api.basic.NetworkResponseType;
import szu.whale.wenote.util.CustomProgressDialog;
import szu.whale.wenote.util.ToastUtil;


/**
 * funtion :一个控制展示dialog以及错误控制的subscriber
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public abstract class NetworkSubscriber<T> extends Subscriber<T> {

    //对应HTTP的状态码,不是服務器状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;


    private Context context;
    private boolean isShowWaitDialog;
    private CustomProgressDialog waitDialog;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setIsShowWaitDialog(boolean showWaitDialog) {
        isShowWaitDialog = showWaitDialog;
    }

    private void showWaitDialog() {
        waitDialog.show();
    }

    private void dissmissDialog() {
        waitDialog.dismiss();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isShowWaitDialog) {
            showWaitDialog();
        }
    }

    @Override
    public void onCompleted() {
        if (isShowWaitDialog) {
            dissmissDialog();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (isShowWaitDialog) {
            dissmissDialog();
        }
        Throwable throwable = e;
        /*
        * 获取异常根源
        * */
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        //http请求错误
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {
                case UNAUTHORIZED:
                    ToastUtil.showMsgShort(context, "未授权");
                    break;
                case FORBIDDEN:
                    ToastUtil.showMsgShort(context, "没有网络访问权限");
                    //  onPermissionError(ex);          //权限错误，需要实现
                    break;
                case NOT_FOUND:
                    ToastUtil.showMsgShort(context, "未找到网络");
                    break;
                case REQUEST_TIMEOUT:
                    ToastUtil.showMsgShort(context, "请求超时");
                    break;
                case GATEWAY_TIMEOUT:
                    ToastUtil.showMsgShort(context, "网关请求超时");
                    break;
                case INTERNAL_SERVER_ERROR:
                    ToastUtil.showMsgShort(context, "端口错误");
                    break;
                case BAD_GATEWAY:
                    ToastUtil.showMsgShort(context, "错误网关");
                    break;
                case SERVICE_UNAVAILABLE:
                    ToastUtil.showMsgShort(context, "找不到服务器");
                    break;
                default:
                    ToastUtil.showMsgShort(context, "网络错误");
                    break;
            }
        }
        //服务器返回的错误码
        else if (e instanceof NetworkException) {
            onNextError((NetworkException) e);
        } else if (e instanceof JsonParseException || e instanceof ParseException || e instanceof JSONException) {
            ToastUtil.showMsgShort(context, "json解析错误");
        } else if (e instanceof UnknownHostException) {
            ToastUtil.showMsgShort(context, "未知异常");
        } else if (e instanceof SocketTimeoutException) {
            ToastUtil.showMsgShort(context, "socket连接超时");
        } else {
            e.printStackTrace();
            ToastUtil.showMsgShort(context, "网络加载失败");
        }
    }

    //根据服务器返回的错误码来显示不同的toast
    private void onNextError(NetworkException e) {
        switch (e.getCode() + "") {
            case NetworkResponseType.STATUS_600211:
                ToastUtil.showMsgShort(context, "token已过期");
                break;
            case NetworkResponseType.STATUS_6003:
                ToastUtil.showMsgShort(context, "暂无数据");
                break;
            default:
                String errorMsg = e.getMessage();
                if (TextUtils.isEmpty(errorMsg)) {
                    ToastUtil.showMsgShort(context, errorMsg);
                } else {
                    ToastUtil.showMsgShort(context, errorMsg);
                }
                break;
        }
    }
}
