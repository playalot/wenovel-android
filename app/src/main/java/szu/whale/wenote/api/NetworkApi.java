package szu.whale.wenote.api;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public interface NetworkApi {

    @POST("open/open.do")
    Observable<ResponseInfo<Object>>response(@Query("ACID") int acid , @Body RequestBody requestBody);

}
