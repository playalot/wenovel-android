package szu.whale.wenote.base;



import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * funtion :用于管理单个presenter的rxbus事件和rxjava相关代码的生命周期处理。
 * author  :smallbluewhale.
 * date    :2017/4/5 0005.
 * version :1.0.
 */
public class RxManager {
    public RxBus mRxbus = RxBus.getInstance();
    //管理rxbus订阅的map
    private Map<String, Flowable<?>> mObservableMap = new HashMap<>();
    /*
    * 管理Observable和Subscribe订阅
    * 取消以及注册订阅
    * */
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    /*
    * Rxbus注入监听
    * */
    public <T> void onEvent(String eventName , Consumer<T> action1){
        Flowable<T>observable = mRxbus.register(eventName);
        mObservableMap.put(eventName,observable);
        /*订阅管理*/
        compositeDisposable.add(observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {

            }
        }));
    }

    /*
    * 单纯的obserables和subscribers管理
    * */
    public void add(Disposable disposable){
        /*订阅管理*/
        compositeDisposable.add(disposable);
    }


    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    public void clear(){
        compositeDisposable.clear();
        for (Map.Entry<String,Flowable<?>> entry:mObservableMap.entrySet()) {
            mRxbus.unRegister(entry.getKey(),entry.getValue());
        }
        
    }

}

