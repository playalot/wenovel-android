package szu.whale.wenote.api.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * funtion :可以自己控制网络请求的线程以及发起请求的线程(主线程or子线程)并且在这里可以对数据进行加密解密
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkUtil {

    public static RequestBody toBody(HashMap hashMap) {
        Gson gson = new Gson();
        //设置服务器返回数据的格式，表单还是json
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(hashMap));
    }

    public static RequestBody toBody(JsonObject jsonObject) {
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
    }


}
