package szu.whale.wenote.module.login.presenter;

import android.content.Context;

import java.util.HashMap;

import szu.whale.wenote.api.ApiSubscriber;
import szu.whale.wenote.api.MobileApi;
import szu.whale.wenote.api.RtHttp;
import szu.whale.wenote.base.BasePresenter;
import szu.whale.wenote.module.login.contract.LoginContract;


/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/14 0014.
 * version :1.0.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(Context context){
        this.mContext = context;
    }


    @Override
    public void login(String userName, String passWord) {
        HashMap<String , String> hashMap = null;
        hashMap.put("userName",userName);
        hashMap.put("passWord",passWord);
        if (!checkUserInput(userName, passWord)) return;

        mView.get().showLoading();
        /*
        * 调用model层来获取数据d
        * */
        RtHttp.with(mContext).setDialog(true).setObservable(MobileApi.response(hashMap)).subScriber(new ApiSubscriber() {
            @Override
            public void onNext(Object o) {

            }
        });
    }


    private boolean checkUserInput(String userName, String passWord) {
        if (userName.length() < 15) {
            mView.get().userNameError();
            return false;
        }

        if (passWord.length() < 6 || passWord.length() > 16) {
            mView.get().passWordError();
            return false;
        }

        return true;
    }
}
