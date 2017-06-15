package szu.whale.wenote.base;

import android.content.Context;

import java.lang.ref.WeakReference;


/**
 * Presenter基类, Fragment需使用继承自此类的子类, 泛型需传入继承自{@link BaseView}的MVPView.
 *
 * 子类可直接调用通过attachView传递过来的view来操作Activity, 无需再声明绑定.
 *
 * 如子类需要自行管理生命周期, 请在Activity/Fragment的onCreate中调用{@link #attachView}方法,
 * 并一定要在onDestroy中调用{@link #detachView}, 以防内存溢出.
 *
 * Created by smallbluewhale on 2017/3/21 0021.
 */

public abstract class BasePresenter<V extends BaseView> {

    private RxManager mRxManager = new RxManager();
    protected WeakReference<V> mView;                     //弱引用
    protected Context mContext;

    public void attachView(V view){
        this.mView = new WeakReference<V>(view);
        this.onStart();
    }

    protected String getString(int resId){
        return mView.get().getContext().getString(resId);
    }

    public void onStart(){

    }
    public void onDestory(){
        mRxManager.clear();
    }

    public void detachView(){
        mView = null;
    }
}
