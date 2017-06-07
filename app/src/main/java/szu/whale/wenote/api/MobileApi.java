package szu.whale.wenote.api;

import java.util.HashMap;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * funtion :
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

    public static Observable getObservable(Observable observable){
        observable = new ObservableBuilder(observable)
                .setAddApiException(true)
                .build();
        return observable;
    }

    public static Observable response(HashMap map , int protocoid){
        RequestBody requestBody = toBody(map);
        return getObservable(getNetworkApi().response(protocoid , requestBody));

    }
}
