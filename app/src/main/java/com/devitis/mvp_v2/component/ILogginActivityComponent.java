package com.devitis.mvp_v2.component;

import android.content.Context;

import com.devitis.mvp_v2.LoginActivity;
import com.devitis.mvp_v2.module.LoginActivityContextModule;
import com.devitis.mvp_v2.module.LoginActivityMvpModule;
import com.devitis.mvp_v2.qualifier.ActivityContext;
import com.devitis.mvp_v2.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Diana on 22.03.2019.
 */

@ActivityScope
@Component(modules = {LoginActivityContextModule.class, LoginActivityMvpModule.class},
        dependencies = IApplicationComponent.class)
public interface ILogginActivityComponent {

    @ActivityContext
    Context getContext();

    void injectLoginActivity(LoginActivity loginActivity);
}
