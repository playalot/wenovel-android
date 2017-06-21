package szu.whale.wenote.module.login.contract;

import szu.whale.wenote.base.BaseView;

/**
 * author  :smallbl
 * funtion :uewhale.
         * date    :2017/6/13 0013.
         * version :1.0.
         */
public interface RegisterContract {
    interface Presenter {
        void login(String mobile , String passWord);
    }

    interface View extends BaseView{
        void loginComplete();
        void userNameError();
        void passWordError();
    }
}
