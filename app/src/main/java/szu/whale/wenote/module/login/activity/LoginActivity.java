package szu.whale.wenote.module.login.activity;

import android.os.Bundle;

import szu.whale.wenote.R;
import szu.whale.wenote.base.BaseActivity;
import szu.whale.wenote.module.login.contract.LoginContract;
import szu.whale.wenote.module.login.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginContract.View,LoginPresenter> implements LoginContract.View{
    private String mString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mString = "hellow world";
    }

    @Override
    public void loginComplete() {

    }

    @Override
    public void userNameError() {

    }

    @Override
    public void passWordError() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
