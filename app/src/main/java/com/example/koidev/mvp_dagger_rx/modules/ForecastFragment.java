package com.example.koidev.mvp_dagger_rx.modules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.koidev.mvp_dagger_rx.R;
import com.example.koidev.mvp_dagger_rx.dagger.components.DaggerForecastComponent;
import com.example.koidev.mvp_dagger_rx.dagger.module.ForecastModule;
import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;
import com.example.koidev.mvp_dagger_rx.mvp.presenter.ForecastPresenter;
import com.example.koidev.mvp_dagger_rx.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Valentin Baryshev.
 */

public class ForecastFragment extends BaseFragment implements MainView {

    public static ForecastFragment newInstance() {
        return new ForecastFragment();
    }

    @Inject
    ForecastPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), "Presenter " + presenter + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_forecast;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerForecastComponent.builder()
                .applicationComponent(getApplicationComponent())
                .forecastModule(new ForecastModule(this))
                .build().inject(this);
    }


    @Override
    public void onForecastLoaded(List<Forecast> forecasts) {

    }

    @Override
    public void onShowDialog(String message) {

    }

    @Override
    public void onHideDialog() {

    }

    @Override
    public void onShowToast(String message) {

    }
}
