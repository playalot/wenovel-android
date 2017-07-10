package szu.whale.wenote.api;

import android.content.Context;

import java.lang.ref.WeakReference;

import rx.Observable;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkRequest {

    public static final String TAG = "NetworkRequest";
    public static NetworkRequest instance = new NetworkRequest();           //单例饿汉模式 最简单的一种单例模式
    private static WeakReference<Context> wrContext;
    private Observable observable;
    private boolean isShowingDialog;

    public static NetworkRequest with(Context context) {
        wrContext = new WeakReference<Context>(context);
        return instance;
    }


    public NetworkRequest setShowingDialog() {
        this.isShowingDialog = false;
        return instance;
    }

    public NetworkRequest setObservable(Observable observable) {
        this.observable = observable;
        return instance;
    }


    /*
    * 在这里设置一个订阅者
    * 能够显示dialog以及根据不同网络状态显示做出不同反应
    * */
    public NetworkRequest subScriber(NetworkSubscriber networkSubscriber) {
        networkSubscriber.setContext(wrContext.get());
        networkSubscriber.setIsShowWaitDialog(isShowingDialog);
        observable.subscribe(networkSubscriber);
        return instance;
    }
}
