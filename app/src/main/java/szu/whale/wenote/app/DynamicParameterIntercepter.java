package szu.whale.wenote.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * funtion :添加动态参数的拦截器
 * author  :smallbluewhale.
 * date    :2017/6/6 0006.
 * version :1.0.
 */
class DynamicParameterIntercepter implements Interceptor {

    HashMap<String , String> map;

    public DynamicParameterIntercepter(HashMap<String, String> dynamicParameterMap) {
            this.map = dynamicParameterMap;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder builder = request.url().newBuilder();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            builder.addQueryParameter((String) entry.getKey() , (String) entry.getValue());
        }
        request = request.newBuilder().url(builder.build()).build();
        return chain.proceed(request);
    }
}
