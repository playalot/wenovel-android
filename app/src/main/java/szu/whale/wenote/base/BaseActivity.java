package szu.whale.wenote.base;

import android.app.Activity;
import android.content.Context;


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
}
