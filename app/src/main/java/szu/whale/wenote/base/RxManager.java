package szu.whale.wenote.base;



import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 *
 * 这里不用单例模式的原因是.
 * RxManager是用来管理某一个activity或则fragment中的所有rxjava流程代码，如果用单例的话clear的时候需要按照不同的tag来清除相应的rxManager
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
        Flowable<T>flowable = mRxbus.register(eventName);
        mObservableMap.put(eventName,flowable);
        /*订阅管理*/
        compositeDisposable.add(flowable.observeOn(AndroidSchedulers.mainThread())
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
    /*
    * 发送信息
    * */
    public void post(Object tag , Object content){
        mRxbus.post(tag , content);
    }

}

