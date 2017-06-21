package szu.whale.wenote.api.basic;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Observable;
import szu.whale.wenote.api.NetworkBaseApi;
import szu.whale.wenote.api.NetworkRequest;

/**
 * funtion :继承baseapi，指定观察者和被观察者所在的线程，同时根据服务端返回去的内容形式指定json还是string格式。
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkApi extends NetworkBaseApi {

    private static INetworkApi encryptionINetworkApi;
    private static INetworkApi iNetworkApi;
    private static Observable observable;

    public static INetworkApi getINetworkApi(boolean isEncryption){
        //請求提是否加密
        if(!isEncryption) {
            if (iNetworkApi == null) {
                iNetworkApi = new NetworkRequest.NetWorkApiBuilder()
                        .setSessionId()         //设置sessionid
                        .setParameter()         //设置固定参数
                        .build();
            }
            return iNetworkApi;
        }else{
            if(encryptionINetworkApi == null){
                encryptionINetworkApi = new NetworkRequest.NetWorkApiBuilder()
                        .setSessionId()         //设置sessionid
                        .setParameter()         //設置參數
                        .setEncryption(true)    //设置加密
                        .build();
            }
            return encryptionINetworkApi;
        }
    }


    /** 在这里可以指定observable1发起的线程
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
        return getObservable(getINetworkApi(false).response(requestBody));
    }
}
