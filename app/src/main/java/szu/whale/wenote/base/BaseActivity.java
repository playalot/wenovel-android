package szu.whale.wenote.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import szu.whale.wenote.util.CustomProgressDialog;


/**
 * funtion :个人认为在代码很少或则没什么逻辑结构的情况下的mvp并没有必要去使用，可以直接使用非mvp模式去开发
 * author  :smallbluewhale.
 * date    :2017/4/11 0011.
 * version :1.0.
 */
/**
 * 基类
 */
/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class BaseActivity<V extends BaseView,P extends BasePresenter<V>> extends Activity implements BaseView  {

    protected P presenter;
    private CustomProgressDialog customProgressDialog;


    protected abstract int getLayoutId();

    protected abstract void initPresenter();

    /*
    * 仅在这里做初始化操作
    * */
    protected abstract void init(Bundle savedInstanceState);


    protected abstract P createPresenter();


    public P getPresenter() {
        return presenter;
    }



    /*
    * 用来显示加载中的dialog
    *
    * */
    public CustomProgressDialog getLoadingDialog(){
        return customProgressDialog;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToastMessage() {

    }

    @Override
    public void showEmptyViewMessage() {

    }

    @Override
    public void hideEmptyViewMessage() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
