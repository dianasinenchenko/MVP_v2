package com.devitis.mvp_v2.module;

import com.devitis.mvp_v2.IApiService;
import com.devitis.mvp_v2.ILoginActivityContract;
import com.devitis.mvp_v2.LoginPresenterImpl;
import com.devitis.mvp_v2.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 22.03.2019.
 */

@Module
public class LoginActivityMvpModule {

    private ILoginActivityContract.IView iView;

    public LoginActivityMvpModule(ILoginActivityContract.IView iView) {
        this.iView = iView;
    }


    @Provides
    @ActivityScope
    ILoginActivityContract.IView provideView() {
        return iView;
    }

    @Provides
    @ActivityScope
    LoginPresenterImpl providePresenter(IApiService iApiService, ILoginActivityContract.IView iView) {
        return new LoginPresenterImpl(iApiService, iView);
    }

}
