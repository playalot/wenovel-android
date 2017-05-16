package szu.whale.wenote.base;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public abstract class BasePresenter<V extends BaseView> {
    private Context context;
    private RxManager mRxManager = new RxManager();
    private V mView;
    public void attachView(V view){
        this.mView  = view;
        this.onStart();
    }

    public void onStart(){

    }
    public void onDestory(){
        mRxManager.clear();
    }


}
