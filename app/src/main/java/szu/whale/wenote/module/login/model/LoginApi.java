package szu.whale.wenote.module.login.model;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import szu.whale.wenote.api.NetworkApi;
import szu.whale.wenote.api.ResponseInfo;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public interface LoginApi extends NetworkApi{

    @POST("open/open.do")
    Observable<ResponseInfo<Object>>response(@Body RequestBody requestBody);


}
