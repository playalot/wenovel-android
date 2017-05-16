package szu.whale.wenote.base;

import android.content.Context;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/4/7 0007.
 * version :1.0.
 */
public interface BaseView {
    /*
    * 显示加载框
    * */
    void showLoading();
    /*
    * 隐藏加载框
    * */
    void hideLoading();
    /*
    * 显示提示消息
    * */
    void showToastMessage();
    /*
    * 显示空列表信息
    * */
    void showEmptyViewMessage();
    /*
    * 隐藏空列表信息
    * */
    void hideEmptyViewMessage();
    /*
    * 获取context对象
    * */
    Context getContext();
}
