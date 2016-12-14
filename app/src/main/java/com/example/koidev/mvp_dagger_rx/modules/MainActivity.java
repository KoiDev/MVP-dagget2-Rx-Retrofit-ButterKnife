package com.example.koidev.mvp_dagger_rx.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.koidev.mvp_dagger_rx.R;
import com.example.koidev.mvp_dagger_rx.dagger.components.DaggerForecastComponent;
import com.example.koidev.mvp_dagger_rx.dagger.module.ForecastModule;
import com.example.koidev.mvp_dagger_rx.modules.adapter.ForecastAdapter;
import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;
import com.example.koidev.mvp_dagger_rx.mvp.presenter.ForecastPresenter;
import com.example.koidev.mvp_dagger_rx.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends NavigationDrawerActivity implements MainView {

    @BindView(R.id.forecast_recview)
    RecyclerView mForecastList;

    private ForecastAdapter mForecastAdapter;

    @Inject protected ForecastPresenter mPresenter;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getForecast();
    }

    private void initializeList() {
        mForecastList.setHasFixedSize(true);
        mForecastList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mForecastAdapter = new ForecastAdapter(getLayoutInflater());
        mForecastList.setAdapter(mForecastAdapter);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
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
        mForecastAdapter.addForecast(forecasts);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
