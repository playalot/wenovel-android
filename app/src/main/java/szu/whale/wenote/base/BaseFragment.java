package szu.whale.wenote.base;

/**
 * funtion :个人认为在代码很少或则没什么逻辑结构的情况下的mvp并没有必要去使用，可以直接使用非mvp模式去开发
 * author  :smallbluewhale.
 * date    :2017/4/11 0011.
 * version :1.0.
 * /
 * /**
 * 基类
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/***************使用例子*********************/
//1.mvp模式
//public class SampleFragment extends BaseFragment<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
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
//public class SampleFragment extends BaseFragment {
//    @Override
//    public int getLayoutResource() {
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

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {
    protected Context mContext;
    protected RxManager mRxManager;
    protected View mRootView;
    private P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutID(), container, false);
        }
        mRxManager = new RxManager();
        ButterKnife.bind(this, mRootView);
        presenter = createPresenter();
        if(presenter!=null){
            presenter.attachView((V)this);
        }
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(presenter!=null){
            presenter.detachView();
        }
        mRxManager.clear();
    }

    protected P getPresenter(){
        if(presenter == null){
            presenter = createPresenter();
        }
        return presenter;
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

    /*
    * 设置fragment的布局layout
    * */
    protected abstract int getLayoutID();

    /*
        * 不同activity实现不同presenter
        * */
    protected abstract P createPresenter();

    /*
    * class跳转
    * */


}
