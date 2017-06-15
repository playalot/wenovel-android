package szu.whale.wenote.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * funtion :可以自己控制网络请求的线程以及发起请求的线程(主线程or子线程)
 * author  :smallbluewhale.
 * date    :2017/6/5 0005.
 * version :1.0.
 */
public abstract class NetworkBaseApi {

    public static RequestBody toBody(HashMap hashMap){
        Gson gson = new Gson();
        //设置服务器返回数据的格式，表单还是json
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8") , gson.toJson(hashMap));
    }

    public static RequestBody toBody(JsonObject jsonObject){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8") , jsonObject.toString());
    }



    //使用建造者模式在它的子类去生成一个不同的baseapi
    public static class ObservableBuilder{
        private Observable observable;
        private Scheduler observableScheduler;      //观察者所在的线程
        private Scheduler subscriberScheduler;      //订阅者所在的线程
        private boolean isWebApi;
        private boolean isToJsonObject;
        private boolean isAddApiException;

        public ObservableBuilder(Observable observable){
            this.observable = observable;
        }

        public ObservableBuilder setObservableScheduler(Scheduler observableScheduler){
            this.observableScheduler = observableScheduler;
            return this;
        }

        public ObservableBuilder setSubscriberScheduler(Scheduler subscriberScheduler){
            this.subscriberScheduler = subscriberScheduler;
            return this;
        }

        public ObservableBuilder setWebApi(boolean isWebApi){
            this.isWebApi = isWebApi;
            return this;
        }

        public ObservableBuilder setTojsonObject(boolean isToJsonObject){
            this.isToJsonObject = isToJsonObject;
            return this;
        }

        public ObservableBuilder setAddApiException(boolean isAddApiException){
            this.isAddApiException = isAddApiException;
            return this;
        }


        public Observable build(){
            if(isWebApi){
            }
            if(isToJsonObject){

            }
            if(isAddApiException){
                observable = observable.flatMap(new NetworkErrorCodeFunc1());
            }
            if(observableScheduler!=null){
                observable = observable.observeOn(observableScheduler);
            }else{
                observable = observable.observeOn(AndroidSchedulers.mainThread());
            }
            if(subscriberScheduler!=null){
                observable.subscribeOn(subscriberScheduler);
            }else{
                observable = observable.subscribeOn(Schedulers.io());
            }
            return observable;
        }
    }
}
