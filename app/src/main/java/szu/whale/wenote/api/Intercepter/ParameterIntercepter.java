package szu.whale.wenote.api.Intercepter;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * funtion :增加固定参数的拦截器
 * author  :smallbluewhale.
 * date    :2017/6/6 0006.
 * version :1.0.
 */
public class ParameterIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //get请求参数,在url后面去添加
        Request request = chain.request();
        HttpUrl httpUrl = request
                .url()
                .newBuilder()
                .addQueryParameter("channelID", "")
                .addQueryParameter("clientID", "")
                .addQueryParameter("revision", "")
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);

    }
}
