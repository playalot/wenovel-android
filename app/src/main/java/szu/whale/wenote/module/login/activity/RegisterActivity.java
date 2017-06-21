package szu.whale.wenote.module.login.activity;

import android.os.Bundle;

import szu.whale.wenote.R;
import szu.whale.wenote.base.BaseActivity;
import szu.whale.wenote.module.login.contract.RegisterContract;
import szu.whale.wenote.module.login.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity<RegisterContract.View,RegisterPresenter> implements RegisterContract.View{
    private String mString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mString = "hellow world";
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        String mobile = "15889680545";
        String passWord = "Q4561210q";
        presenter.login(mobile,passWord);
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
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
