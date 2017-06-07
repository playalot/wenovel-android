package szu.whale.wenote.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/6 0006.
 * version :1.0.
 */
class ParameterIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //get请求参数,在url后面去添加
        Request request = chain.request();
        HttpUrl httpUrl = request
                .url()
                .newBuilder()
                .addQueryParameter("userid", "")
                .addQueryParameter("cityid", "")
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);

    }
}
