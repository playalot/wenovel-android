package szu.whale.wenote.base;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * funtion :用rxbus和rxandroid实现的一个事件监听的类
 * author  :smallbluewhale.
 * date    :2017/3/21 0021.
 * version :1.0.
 */
public class RxBus {
    private static RxBus instance;


    RxBus(){

    }
    public static RxBus getInstance(){
        if(null==instance){
            synchronized (RxBus.class){
                instance = new RxBus();
            }
        }
        return  instance;
    }


    //每一种tag类型有一个同种类型事件的lsit
    private ConcurrentHashMap<Object , List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    /**
     * 订阅事件源
     *
     * @param mObservable
     * @param mAction1
     * @return
     */
    public RxBus onEvent(Observable<?> mObservable , Action1<Object> mAction1){
        mObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(mAction1, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return getInstance();
    }


    /**
     * 注册事件源
     * 1.将事件按照tag标志放置在一个map中，然后不同tag事件对应不同一个subjectlist
     * 2.再创建一个tag对应的subject放在
     * @param tag
     * @return
     */
    public <T> Observable<T> register(@NonNull Object tag){
        List<Subject> subjectList = subjectMapper.get(tag);
        if(null == subjectList){
            subjectList = new ArrayList<>();
            subjectMapper.put(tag,subjectList);
        }
        Subject<T,T> subject = PublishSubject.create();
        subjectList.add(subject);
        return subject;
    }

    /*
    * 简单发送事件
    * 默认设置content的类名为tag标志
    * */
    public void post(@NonNull Object content){
        post(content.getClass().getName(),content);
    }


    /**
     * 触发事件
     * 遍历全部相同tag事件的list，然后将相同的时间全部post出去，利用subject的一些有用的特性，例如可以构造一个无发送事件的observable
     * @param content
     */
    public void post(@NonNull Object tag,@NonNull Object content){
        List<Subject> subjectList = subjectMapper.get(tag);
        if(!isEmpty(subjectList)){
            for (Subject subject :
                    subjectList) {
                subject.onNext(content);
            }

        }
    }

    /**
     * 解绑事件
     * @param content
     */
    public void unRegister(@NonNull Object content){
        List<Subject> subjectList = subjectMapper.get(content);
        if(null != subjectList){
            subjectMapper.remove(content);
        }
    }

    /**
     * 取消监听
     *
     * @param tag
     * @param observable
     * @return
     */
    public RxBus unRegister(@NonNull Object tag , @NonNull Observable<?>observable){
        if(null == observable){
            getInstance();
        }
        List<Subject> subjectList = subjectMapper.get(tag);
        if(null != subjectList){
            subjectList.remove((Subject<?,?>)observable);
            if(isEmpty(subjectList)){
                subjectMapper.remove(tag);
            }
        }
        return getInstance();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection<Subject> collection) {
        return null == collection || collection.isEmpty();
    }



}
