package szu.whale.wenote.api.builder;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import szu.whale.wenote.api.observable.NetworkErrorCodeFunc1;

/**
 * funtion :通过原来的observable来构建一个新observable，改变所在调用的线程。
 * author  :smallbluewhale.
 * date    :2017/7/7 0007.
 * version :1.0.
 */
//
public class ObservableBuilder {
        private Observable observable;
        private Scheduler observableScheduler;      //观察者所在的线程
        private Scheduler subscriberScheduler;      //订阅者所在的线程
        private boolean isWebApi;
        private boolean isToJsonObject;
        private boolean isAddApiException;

        public ObservableBuilder(Observable observable) {
            this.observable = observable;
        }

        public ObservableBuilder setObservableScheduler(Scheduler observableScheduler) {
            this.observableScheduler = observableScheduler;
            return this;
        }

        public ObservableBuilder setSubscriberScheduler(Scheduler subscriberScheduler) {
            this.subscriberScheduler = subscriberScheduler;
            return this;
        }

        public ObservableBuilder setWebApi(boolean isWebApi) {
            this.isWebApi = isWebApi;
            return this;
        }

        public ObservableBuilder setTojsonObject(boolean isToJsonObject) {
            this.isToJsonObject = isToJsonObject;
            return this;
        }

        public ObservableBuilder setAddApiException(boolean isAddApiException) {
            this.isAddApiException = isAddApiException;
            return this;
        }


        public Observable build() {
            if (isWebApi) {
            }
            if (isToJsonObject) {

            }
            if (isAddApiException) {
                observable = observable.flatMap(new NetworkErrorCodeFunc1()); //将返回的
            }
            if (observableScheduler != null) {
                observable = observable.observeOn(observableScheduler);
            } else {
                observable = observable.observeOn(AndroidSchedulers.mainThread());
            }
            if (subscriberScheduler != null) {
                observable.subscribeOn(subscriberScheduler);
            } else {
                observable = observable.subscribeOn(Schedulers.io());
            }
            return observable;
        }
    }
