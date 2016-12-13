package com.example.koidev.mvp_dagger_rx.dagger.components;

import com.example.koidev.mvp_dagger_rx.dagger.module.ForecastModule;
import com.example.koidev.mvp_dagger_rx.dagger.scope.PerActivity;
import com.example.koidev.mvp_dagger_rx.modules.MainActivity;

import dagger.Component;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

@PerActivity
@Component(modules = ForecastModule.class, dependencies = ApplicationComponent.class)
public interface ForecastComponent {

    void inject(MainActivity mainActivity);
}
