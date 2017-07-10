package szu.whale.wenote.api.Intercepter;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * funtion :给url加上公共的请求头拦截器
 * author  :smallbluewhale.
 * date    :2017/6/6 0006.
 * version :1.0.
 */
public class HeaderInterceptor implements Interceptor {

    private Context context;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //get请求参数,在url后面去添加
        Request request = chain.request();
        Request.Builder builder = request
                .newBuilder();
//                .header("sessionId" , "");
        request = builder.build();
        return chain.proceed(request);
    }
}
