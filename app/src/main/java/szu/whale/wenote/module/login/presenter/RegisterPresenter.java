package szu.whale.wenote.module.login.presenter;

import android.content.Context;

import java.util.HashMap;

import szu.whale.wenote.api.NetworkRequest;
import szu.whale.wenote.api.NetworkSubscriber;
import szu.whale.wenote.api.basic.NetworkApi;
import szu.whale.wenote.api.basic.ResponseInfo;
import szu.whale.wenote.base.BasePresenter;
import szu.whale.wenote.module.login.contract.RegisterContract;
import szu.whale.wenote.module.login.entity.User;


/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/14 0014.
 * version :1.0.
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    public RegisterPresenter(Context context) {
        this.mContext = context;
    }


    @Override
    public void login(String userName, String passWord) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile", "17607557882");
        hashMap.put("checkCode", "7368");
        hashMap.put("password", "Q4561210q");
        hashMap.put("cityId", "10");
        mView.get().showLoading();
        /*
        * 调用model层来获取数据d
        * */
        NetworkRequest.with(mContext)
                .setShowingDialog(false)
                .setObservable(NetworkApi.register(hashMap))
                .subScriber(new NetworkSubscriber<ResponseInfo<User>>() {
                    //数据成功
                    @Override
                    public void onNext(ResponseInfo<User> result) {
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
