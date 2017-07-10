package szu.whale.wenote.api.builder;

import android.text.TextUtils;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import szu.whale.wenote.api.Intercepter.DynamicParameterInterceptor;
import szu.whale.wenote.api.Intercepter.EncryptionInterceptor;
import szu.whale.wenote.api.Intercepter.HeaderInterceptor;
import szu.whale.wenote.api.Intercepter.LoggerInterceptor;
import szu.whale.wenote.api.Intercepter.ParameterInterceptor;
import szu.whale.wenote.api.basic.INetworkApi;
import szu.whale.wenote.api.basic.NetworkConfig;

/**
 * funtion :builder用来设置retrofit的builder以及okhttp的builder
 * author  :smallbluewhale.
 * date    :2017/7/7 0007.
 * version :1.0.
 */
public class NetworkBuilder {

    private String baseUrl;
    private boolean isEncryption;                        //是否加密
    private boolean isAddSeesionId;                      //是否加入sessionid
    private boolean isAddParameter;                      //url添加固定参数
    private HashMap<String, String> dynamicParameterMap;  //动态参数
    private Retrofit.Builder rtBuilder;
    private OkHttpClient.Builder okBuilder;
    private Converter.Factory converterFactory;          //用于类型转换的converter


    public NetworkBuilder setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public NetworkBuilder setEncryption() {
        this.isEncryption = true;
        return this;
    }

    public NetworkBuilder setConverterFactory(Converter.Factory converterFactory) {
        this.converterFactory = converterFactory;
        return this;
    }

    public NetworkBuilder setParameter() {
        isAddParameter = true;
        return this;
    }

    public NetworkBuilder setSessionId() {
        isAddSeesionId = true;
        return this;
    }

    public NetworkBuilder setDynamicParameterMap(HashMap dynamicParameterMap) {
        this.dynamicParameterMap = dynamicParameterMap;
        return this;
    }

    public INetworkApi build() {
        rtBuilder = new Retrofit.Builder();
        okBuilder = new OkHttpClient.Builder();
        if (!TextUtils.isEmpty(baseUrl)) {
            rtBuilder.baseUrl(baseUrl);
        } else {
            rtBuilder.baseUrl(NetworkConfig.getBaseUrl());
        }
        if (isEncryption) {
            okBuilder.addInterceptor(new EncryptionInterceptor());
        }
        if (isAddSeesionId) {
            okBuilder.addInterceptor(new HeaderInterceptor());
        }
        if (isAddParameter) {
            okBuilder.addInterceptor(new ParameterInterceptor());
        }
        if (dynamicParameterMap != null) {
            okBuilder.addInterceptor(new DynamicParameterInterceptor(dynamicParameterMap));
        }

        if (!NetworkConfig.isDebug()) {
            okBuilder.addInterceptor(new LoggerInterceptor());
        }
        if (converterFactory != null) {
            rtBuilder.addConverterFactory(converterFactory);
        } else {
            rtBuilder.addConverterFactory(GsonConverterFactory.create());
        }
        rtBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okBuilder.build());
        return rtBuilder.build().create(INetworkApi.class);
    }


}
