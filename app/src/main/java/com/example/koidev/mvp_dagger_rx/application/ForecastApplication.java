package com.example.koidev.mvp_dagger_rx.application;

import android.app.Application;

import com.example.koidev.mvp_dagger_rx.dagger.components.ApplicationComponent;
import com.example.koidev.mvp_dagger_rx.dagger.components.DaggerApplicationComponent;
import com.example.koidev.mvp_dagger_rx.dagger.module.ApplicationModule;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public class ForecastApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this, "http://vprognoze.ru/api/"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
