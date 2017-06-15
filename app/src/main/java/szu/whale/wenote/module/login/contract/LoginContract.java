package szu.whale.wenote.module.login.contract;

import szu.whale.wenote.base.BaseView;

/**
 * author  :smallbl
 * funtion :uewhale.
         * date    :2017/6/13 0013.
         * version :1.0.
         */
public interface LoginContract {
    interface Presenter {
        void login(String userName , String passWord);
    }

    interface View extends BaseView{
        void loginComplete();
        void userNameError();
        void passWordError();
    }
}
