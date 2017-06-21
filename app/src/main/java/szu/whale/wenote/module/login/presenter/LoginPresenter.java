package szu.whale.wenote.module.login.presenter;

import android.content.Context;

import java.util.HashMap;

import szu.whale.wenote.api.NetworkSubscriber;
import szu.whale.wenote.module.login.entity.LoginEntity;
import szu.whale.wenote.api.basic.NetworkApi;
import szu.whale.wenote.api.NetworkRequest;
import szu.whale.wenote.api.basic.ResponseInfo;
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
        NetworkRequest.with(mContext).setShowingDialog(true).setObservable(NetworkApi.response(hashMap)).subScriber(new NetworkSubscriber<ResponseInfo<LoginEntity>>() {
            //数据成功
            @Override
            public void onNext(ResponseInfo<LoginEntity> result) {

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
