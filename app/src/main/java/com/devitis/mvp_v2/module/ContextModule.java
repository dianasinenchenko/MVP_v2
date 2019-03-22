package com.devitis.mvp_v2.module;

import android.content.Context;

import com.devitis.mvp_v2.qualifier.ApplicationContext;
import com.devitis.mvp_v2.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diana on 22.03.2019.
 */
@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
