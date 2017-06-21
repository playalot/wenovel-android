package szu.whale.wenote.api;

import android.content.Context;
import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import szu.whale.wenote.api.Intercepter.DynamicParameterInterceptor;
import szu.whale.wenote.api.Intercepter.EncryptionInterceptor;
import szu.whale.wenote.api.Intercepter.HeaderInterceptor;
import szu.whale.wenote.api.Intercepter.LoggerInterceptor;
import szu.whale.wenote.api.Intercepter.ParameterInterceptor;
import szu.whale.wenote.api.basic.NetworkConfig;
import szu.whale.wenote.api.basic.INetworkApi;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class NetworkRequest {

    public static final String TAG = "NetworkRequest";
    public static NetworkRequest instance = new NetworkRequest();           //单例饿汉模式 最简单的一种单例模式
    private Observable observable;
    private static WeakReference<Context> wrContext;
    private boolean isShowingDialog;

    public static NetworkRequest with(Context context){
        wrContext = new WeakReference<Context>(context);
        return instance;
    }


    public NetworkRequest setShowingDialog(boolean isShowingDialog){
        this.isShowingDialog = isShowingDialog;
        return instance;
    }

    public NetworkRequest setObservable(Observable observable){
        this.observable = observable;
        return instance;
    }


    /*
    * 在这里设置一个订阅者
    * 能够显示dialog以及根据不同网络状态显示做出不同反应
    * */
    public NetworkRequest subScriber(NetworkSubscriber networkSubscriber){
        networkSubscriber.setContext(wrContext.get());
        networkSubscriber.setIsShowWaitDialog(isShowingDialog);
        observable.subscribe(networkSubscriber);
        return instance;
    }


    /*
    * 一个建造者模式的builder用来设置retrofit的builder以及okhttp的builder
    *
    * */
    public static class NetWorkApiBuilder{
        private String baseUrl;
//        private boolean isHttpsRequest;                      //是否是https网络协议
        private boolean isEncryption;                        //是否加密
        private boolean isAddSeesionId;                      //是否加入sessionid
        private boolean isAddParameter;                      //url添加固定参数
        private HashMap<String,String> dynamicParameterMap;  //动态参数
        private Retrofit.Builder rtBuilder;
        private OkHttpClient.Builder okBuilder;
        private Converter.Factory converterFactory;          //用于类型转换的converter


        public NetWorkApiBuilder setBaseUrl(String baseUrl){
            this.baseUrl = baseUrl;
            return this;
        }

        public NetWorkApiBuilder setEncryption(boolean isEncryption){
            this.isEncryption = isEncryption;
            return this;
        }

        public NetWorkApiBuilder setConverterFactory(Converter.Factory converterFactory){
            this.converterFactory = converterFactory;
            return this;
        }

        public NetWorkApiBuilder setParameter(){
            isAddParameter = true;
            return this;
        }

        public NetWorkApiBuilder setSessionId(){
            isAddSeesionId = true;
            return this;
        }

        public NetWorkApiBuilder setDynamicParameterMap(HashMap dynamicParameterMap){
            this.dynamicParameterMap = dynamicParameterMap;
            return this;
        }

        public INetworkApi build(){
            rtBuilder = new Retrofit.Builder();
            okBuilder = new OkHttpClient.Builder();
            if(!TextUtils.isEmpty(baseUrl)){
                rtBuilder.baseUrl(baseUrl);
            }else{
                rtBuilder.baseUrl(NetworkConfig.getBaseUrl());
            }
            if(isEncryption){
                okBuilder.addInterceptor(new EncryptionInterceptor());
            }
            if(isAddSeesionId){
                okBuilder.addInterceptor(new HeaderInterceptor(wrContext.get()));
            }
            if(isAddParameter){
                okBuilder.addInterceptor(new ParameterInterceptor());
            }
            if(dynamicParameterMap!=null){
                okBuilder.addInterceptor(new DynamicParameterInterceptor(dynamicParameterMap));
            }
            /*if(isHttpsRequest){
                okBuilder.addInterceptor(new HttpsRequestIntercepter());
            }*/

            if(!NetworkConfig.isDebug()){
                okBuilder.addInterceptor(new LoggerInterceptor());
            }
            if(converterFactory!=null){
                rtBuilder.addConverterFactory(converterFactory);
            }else{
                rtBuilder.addConverterFactory(GsonConverterFactory.create());
            }
            rtBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okBuilder.build());
            return rtBuilder.build().create(INetworkApi.class);
        }


    }



}
