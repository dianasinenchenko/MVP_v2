package com.devitis.mvp_v2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;

import com.devitis.mvp_v2.component.DaggerILogginActivityComponent;
import com.devitis.mvp_v2.component.IApplicationComponent;
import com.devitis.mvp_v2.component.ILogginActivityComponent;
import com.devitis.mvp_v2.model.LoginResponseModel;
import com.devitis.mvp_v2.module.LoginActivityContextModule;
import com.devitis.mvp_v2.module.LoginActivityMvpModule;
import com.devitis.mvp_v2.qualifier.ActivityContext;
import com.devitis.mvp_v2.qualifier.ApplicationContext;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginActivityContract.IView {

    @BindView(R.id.username_textInput)
    TextInputEditText usernameEditText;

    @BindView(R.id.password_textInput)
    TextInputEditText passwordEditText;

    ILogginActivityComponent logginActivityComponent;


    @Inject
    @ApplicationContext
    public Context context;

    @Inject
    @ActivityContext
    public Context activityContext;


    @Inject
    LoginPresenterImpl loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        IApplicationComponent iApplicationComponent = MyApplication.get(this).iApplicationComponent;

        logginActivityComponent = DaggerILogginActivityComponent.builder()
                .loginActivityContextModule(new LoginActivityContextModule(this))
                .loginActivityMvpModule(new LoginActivityMvpModule(this))
                .iApplicationComponent(iApplicationComponent)
                .build();
        logginActivityComponent.injectLoginActivity(this);

    }


    public void checkPassword(String username, String password){
        if(TextUtils.isEmpty(username)){
            Util.showToast(getApplicationContext(), "Enter valid username");
        }else if(password.length() <= 5){
            Util.showToast(getApplicationContext(), "Please enter password longer than 5 characters");
        }else{
            loginPresenter.loadLoginData(username, password);
        }
    }

    @OnClick(R.id.login_button)
    public void login(){
        checkPassword(usernameEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    public void successfulLogin(LoginResponseModel loginResponseModel) {

        Util.showToast(getApplicationContext(), loginResponseModel.statusMsg);

    }

    @Override
    public void showError(String call, String statusMessage) {

        if (call.equals("network error")) Util.showToast(getApplicationContext(), statusMessage);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showComplete() {

    }
}
