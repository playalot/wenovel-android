package szu.whale.wenote.api;

import rx.Observable;
import rx.functions.Func1;
import szu.whale.wenote.api.basic.NetworkException;
import szu.whale.wenote.api.basic.ResponseInfo;

/**
 * funtion :统一处理错误码code，并且正确时候的将data传给subscriber
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkErrorCodeFunc1<T> implements Func1<ResponseInfo<T>, Observable<T>> {
    @Override
    public Observable<T> call(ResponseInfo<T> responseInfo) {
        //自己根据服务器的错误码显示不同的错误信息
        if(responseInfo.getCode()!=200){
            return Observable.error(new NetworkException(responseInfo.getCode() , responseInfo.getMessage()));
        }
        return Observable.just(responseInfo.getData());
    }
}
