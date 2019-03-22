package com.devitis.mvp_v2;

import android.app.Activity;
import android.app.Application;

import com.devitis.mvp_v2.component.DaggerIApplicationComponent;
import com.devitis.mvp_v2.component.IApplicationComponent;
import com.devitis.mvp_v2.module.ContextModule;

import dagger.android.DaggerApplication;

/**
 * Created by Diana on 22.03.2019.
 */

public class MyApplication extends Application {

    IApplicationComponent iApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyInjection();

    }


    private void dependencyInjection() {
            iApplicationComponent = DaggerIApplicationComponent.builder()
                    .contextModule(new ContextModule(this)).build();

            iApplicationComponent.injectApplication(this);
    }

    public IApplicationComponent getiApplicationComponent() {
        return iApplicationComponent;
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

}
