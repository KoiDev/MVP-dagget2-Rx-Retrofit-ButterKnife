package com.example.koidev.mvp_dagger_rx.dagger.module;

import com.example.koidev.mvp_dagger_rx.api.ApiService;
import com.example.koidev.mvp_dagger_rx.dagger.scope.PerActivity;
import com.example.koidev.mvp_dagger_rx.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */


@Module
public class ForecastModule {

    private MainView mMainView;

    public ForecastModule(MainView view) {
        mMainView = view;
    }

    @PerActivity
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideMainView() {
        return mMainView;
    }
}
