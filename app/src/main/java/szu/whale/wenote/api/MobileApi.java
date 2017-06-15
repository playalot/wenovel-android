package szu.whale.wenote.api;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * funtion :继承baseapi，指定观察者和被观察者所在的线程，同时根据服务端返回去的内容形式指定json还是string格式。
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class MobileApi extends BaseApi {

    private static NetworkApi networkApi;
    private static Observable observable;

    public static NetworkApi getNetworkApi(){
        if(networkApi == null){
            networkApi = new RtHttp.NetWorkApiBuilder()
                    .setSessionId()
                    .setParameter()
                    .build();
        }
        return networkApi;
    }


    /** 在这里可以指定observable发起的线程
    *** 也可以指定subscriber调度的线程
    ***/
    private static Observable getObservable(Observable observable){
        observable = new ObservableBuilder(observable)
                .setAddApiException(true)
//                .setObservableScheduler()
//                .setSubscriberScheduler()
                .build();
        return observable;
    }

    public static Observable response(HashMap map){
        RequestBody requestBody = toBody(map);
        return getObservable(getNetworkApi().response(requestBody));

    }
}
