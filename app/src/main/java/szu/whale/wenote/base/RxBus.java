package szu.whale.wenote.base;

import android.support.annotation.NonNull;

import org.reactivestreams.Processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;


/**
 * funtion :用rxbus和rxandroid实现的一个事件监听的类
 * author  :smallbluewhale.
 * date    :2017/3/21 0021.
 * version :1.0.
 */
public class RxBus {
    private static RxBus instance;

    private RxBus(){

    }
    public static RxBus getInstance(){
        if(null==instance){
            synchronized (RxBus.class){
                instance = new RxBus();
            }
        }
        return  instance;
    }


    //每一种tag类型有一个同种tag类型事件的lsit
    private ConcurrentHashMap<Object , List<Processor>> processorMapper = new ConcurrentHashMap<>();


    /**
     * 注册事件源
     * 1.将事件按照tag标志放置在一个map中，然后不同tag事件对应不同一个subjectlist
     * 2.再创建一个tag对应的subject放在
     * @param tag
     * @return
     */
    public <T> Flowable<T> register(@NonNull Object tag){
        List<Processor> processorList = processorMapper.get(tag);
        if(null == processorList){
            processorList = new ArrayList<>();
            processorMapper.put(tag,processorList);
        }
        FlowableProcessor<T> processor = PublishProcessor.create();
        processorList.add(processor);
        return processor;
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
     * 遍历全部相同tag事件的list，然后将相同的事件全部post出去，利用subject的一些有用的特性，例如可以构造一个无发送事件的observable
     * @param content
     */
    public void post(@NonNull Object tag,@NonNull Object content){
        List<Processor> processorList = processorMapper.get(tag);
        if(!isEmpty(processorList)){
            for (Processor processor :
                    processorList) {
                processor.onNext(content);
            }

        }
    }

    /**
     * 解绑事件
     * @param content
     */
    public void unRegister(@NonNull Object content){
        List<Processor> processorList = processorMapper.get(content);
        if(null != processorList){
            processorMapper.remove(content);
        }
    }

    /**
     * 取消监听
     *
     * @param tag
     * @param flowable
     * @return
     */
    public RxBus unRegister(@NonNull Object tag , @NonNull Flowable<?>flowable){
        if(null == flowable){
            getInstance();
        }
        List<Processor> processorList = processorMapper.get(tag);
        if(null != processorList){
            processorList.remove((Processor)flowable);
            if(isEmpty(processorList)){
                processorMapper.remove(tag);
            }
        }
        return getInstance();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection<Processor> collection) {
        return null == collection || collection.isEmpty();
    }



}
