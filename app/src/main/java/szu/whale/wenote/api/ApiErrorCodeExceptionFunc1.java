package szu.whale.wenote.api;

import rx.Observable;
import rx.functions.Func1;

/**
 * funtion :统一处理错误码code，并且将正确时候的data传给subscriber
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class ApiErrorCodeExceptionFunc1<T> implements Func1<ResponseInfo<T> , Observable<T>> {
    @Override
    public Observable<T> call(ResponseInfo<T> responseInfo) {
        //自己根据服务器的错误码来确定什么时间错误以及正确
        if(responseInfo.getCode()!=200){
            return Observable.error(new ApiException(responseInfo.getCode() , responseInfo.getMessage()));
        }
        return Observable.just(responseInfo.getData());
    }
}
