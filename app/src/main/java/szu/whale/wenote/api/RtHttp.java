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

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public class RtHttp {

    public static final String TAG = "RtHttp";
    public static RtHttp instance = new RtHttp();           //单例饿汉模式 最简单的一种单例模式
    private Observable observable;
    private static WeakReference<Context> wrContext;
    private boolean isShowingDialog;


    public static RtHttp with(Context context){
        wrContext = new WeakReference<Context>(context);
        return instance;
    }


    public RtHttp setDialog(boolean isShowingDialog){
        this.isShowingDialog = isShowingDialog;
        return instance;
    }

    public RtHttp setObservable(Observable observable){
        this.observable = observable;
        return instance;
    }


    /*
    * 在这里设置一个订阅者
    * 能够显示dialog以及根据不同网络状态显示做出不同反应
    * */
    public RtHttp subScriber(ApiSubscriber apiSubscriber){
        apiSubscriber.setContext(wrContext.get());
        apiSubscriber.setIsShowWaitDialog(isShowingDialog);
        observable.subscribe(apiSubscriber);
        return instance;
    }


    /*
    * 一个建造者模式的builder用来设置retrofit的builder以及okhttp的builder
    *
    * */
    public static class NetWorkApiBuilder{
        private String baseUrl;
//        private boolean isHttpsRequest;                      //是否是https网络协议
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

        public NetWorkApiBuilder setConverterFactory(Converter.Factory converterFactory){
            this.converterFactory = converterFactory;
            return this;
        }

        public NetWorkApiBuilder setParameter(){
            isAddParameter = true;
            return this;
        }
        /*
        public NetWorkApiBuilder setHttpsRequest(){
            isHttpsRequest = true;
            return this;
        }
        */

        public NetWorkApiBuilder setSessionId(){
            isAddSeesionId = true;
            return this;
        }

        public NetWorkApiBuilder setDynamicParameterMap(HashMap dynamicParameterMap){
            this.dynamicParameterMap = dynamicParameterMap;
            return this;
        }

        public NetworkApi build(){
            rtBuilder = new Retrofit.Builder();
            okBuilder = new OkHttpClient.Builder();
            if(!TextUtils.isEmpty(baseUrl)){
                rtBuilder.baseUrl(baseUrl);
            }else{
                rtBuilder.baseUrl(ApiConfig.getBaseUrl());
            }
            if(isAddSeesionId){
                okBuilder.addInterceptor(new HeaderIntercepter(wrContext.get()));
            }
            if(isAddParameter){
                okBuilder.addInterceptor(new ParameterIntercepter());
            }
            if(dynamicParameterMap!=null){
                okBuilder.addInterceptor(new DynamicParameterIntercepter(dynamicParameterMap));
            }
            /*if(isHttpsRequest){
                okBuilder.addInterceptor(new HttpsRequestIntercepter());
            }*/

            if(!ApiConfig.isDebug()){
                okBuilder.addInterceptor(new LoggerIntercepter());
            }
            if(converterFactory!=null){
                rtBuilder.addConverterFactory(converterFactory);
            }else{
                rtBuilder.addConverterFactory(GsonConverterFactory.create());
            }
            rtBuilder.addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okBuilder.build());
            return rtBuilder.build().create(NetworkApi.class);
        }


    }



}
