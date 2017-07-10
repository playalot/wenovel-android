package szu.whale.wenote.api;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import szu.whale.wenote.api.basic.ResponseInfo;
import szu.whale.wenote.module.login.entity.User;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public interface INetworkApi {

    @POST("ver4/user/register/v2")
    Observable<ResponseInfo<User>> register(@Body RequestBody requestBody);


}
