package com.devitis.mvp_v2.module;

import android.content.Context;

import com.devitis.mvp_v2.LoginActivity;
import com.devitis.mvp_v2.qualifier.ActivityContext;
import com.devitis.mvp_v2.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 22.03.2019.
 */
@Module
public class LoginActivityContextModule {

    private LoginActivity loginActivity;
    private Context context;

    public LoginActivityContextModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        context = loginActivity;
    }

    @Provides
    @ActivityScope
    public LoginActivity providesLoginActivity() {
        return loginActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context providesContext() {
        return context;
    }
}
