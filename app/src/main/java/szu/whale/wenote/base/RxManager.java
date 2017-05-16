package szu.whale.wenote.base;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * funtion :用于管理单个presenter的rxbus事件和rxjava相关代码的生命周期处理。
 * author  :smallbluewhale.
 * date    :2017/4/5 0005.
 * version :1.0.
 */
public class RxManager {
    public RxBus mRxbus = RxBus.getInstance();
    //管理rxbus订阅的map
    private Map<String, Observable<?>> mObservableMap = new HashMap<>();
    /*
    * 管理Observable和Subscribe订阅
    * 取消以及注册订阅
    * */
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    /*
    * Rxbus注入监听
    * */
    public <T> void onEvent(String eventName , Action1<T> action1){
        Observable<T>observable = mRxbus.register(eventName);
        mObservableMap.put(eventName,observable);
        /*订阅管理*/
        compositeSubscription.add(observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                
            }
        }));
    }

    /*
    * 单纯的obserables和subscribers管理
    * */
    public void add(Subscription subscription){
        /*订阅管理*/
        compositeSubscription.add(subscription);
    }


    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    public void clear(){
        compositeSubscription.unsubscribe();
        for (Map.Entry<String,Observable<?>> entry:mObservableMap.entrySet()) {
            mRxbus.unRegister(entry.getKey(),entry.getValue());
        }
        
    }

}

