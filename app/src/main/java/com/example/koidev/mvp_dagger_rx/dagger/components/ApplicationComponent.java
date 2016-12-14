package com.example.koidev.mvp_dagger_rx.dagger.components;

import android.content.Context;

import com.example.koidev.mvp_dagger_rx.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
