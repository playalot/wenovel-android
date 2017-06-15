package szu.whale.wenote.api.basic;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public interface INetworkApi {

    @POST("open/open.do")
    Observable<ResponseInfo<Object>>response(@Body RequestBody requestBody);

}
