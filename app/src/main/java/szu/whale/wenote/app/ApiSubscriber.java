package szu.whale.wenote.app;

import android.content.Context;

import com.google.gson.JsonParseException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;
import rx.Subscriber;


/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public abstract class ApiSubscriber<T> extends Subscriber<T> {

    private Context context;
    private boolean isShowWaitDialog;
    private WaitDialog waitDialog;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setShowWaitDialog(boolean showWaitDialog) {
        isShowWaitDialog = showWaitDialog;
    }

    private void showWaitDialog() {

    }

    private void dissmissDialog() {

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
        if(isShowWaitDialog){
            dissmissDialog();
        }
        Throwable throwable = e;
        /*
        * 获取异常根源
        * */
        while(throwable.getCause()!=null){
            e = throwable;
            throwable = throwable.getCause();
        }
        if(e instanceof HttpException){
            HttpException httpException = (HttpException)e;

        }else if(e instanceof ApiException){

        }else if(e instanceof JsonParseException){

        }else if(e instanceof UnknownHostException){

        }else if(e instanceof SocketTimeoutException){

        }else{
            e.printStackTrace();

        }
    }
}
