package com.devitis.mvp_v2.component;

import android.content.Context;

import com.devitis.mvp_v2.IApiService;
import com.devitis.mvp_v2.MyApplication;
import com.devitis.mvp_v2.module.ContextModule;
import com.devitis.mvp_v2.module.RetrofitModule;
import com.devitis.mvp_v2.qualifier.ApplicationContext;
import com.devitis.mvp_v2.scope.ApplicationScope;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Diana on 22.03.2019.
 */
@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface IApplicationComponent {

    IApiService getApiService();

    @ApplicationContext
    Context getContext();

    void injectApplication (MyApplication myApplication);

}
