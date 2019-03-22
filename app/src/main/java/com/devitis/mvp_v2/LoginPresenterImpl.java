package com.devitis.mvp_v2;

import android.util.Log;

import com.devitis.mvp_v2.model.LoginResponseModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Diana on 22.03.2019.
 */

public class LoginPresenterImpl implements ILoginActivityContract.IPresenter {

    private IApiService iApiService;
    private ILoginActivityContract.IView iView;


    @Inject
    public LoginPresenterImpl(IApiService iApiService, ILoginActivityContract.IView iView) {

        this.iApiService = iApiService;
        this.iView = iView;
    }

    @Override
    public void loadLoginData(String email, String password) {
        iView.showProgress();

        iApiService.getLoginResponse(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponseModel loginResponseModel) {
                        if (loginResponseModel != null) {
                            if (loginResponseModel.status == 200 || loginResponseModel.status == 201) {
                                iView.successfulLogin(loginResponseModel);
                            } else {
                                iView.showError("Login error", loginResponseModel.statusMsg);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.showError("network error", "error ");
                        Log.e("login", e.getMessage(), e);
                        iView.hideProgress();

                    }

                    @Override
                    public void onComplete() {
                        iView.showComplete();
                        iView.hideProgress();

                    }
                });


    }
}
