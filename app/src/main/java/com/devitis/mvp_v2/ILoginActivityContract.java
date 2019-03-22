package com.devitis.mvp_v2;

import com.devitis.mvp_v2.model.LoginResponseModel;

/**
 * Created by Diana on 22.03.2019.
 */

public interface ILoginActivityContract {

    interface IView {

        void successfulLogin(LoginResponseModel loginResponseModel);

        void showError(String call, String statusMessage);

        void showProgress();

        void hideProgress();

        void showComplete();
    }


    interface IPresenter {
        void loadLoginData(String email, String password);
    }
}
