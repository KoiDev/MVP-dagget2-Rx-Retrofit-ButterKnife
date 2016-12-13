package com.example.koidev.mvp_dagger_rx.mvp.presenter;

import com.example.koidev.mvp_dagger_rx.api.ApiService;
import com.example.koidev.mvp_dagger_rx.base.BasePresenter;
import com.example.koidev.mvp_dagger_rx.mapper.ForecastMapper;
import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;
import com.example.koidev.mvp_dagger_rx.mvp.model.ForecastResponse;
import com.example.koidev.mvp_dagger_rx.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public class ForecastPresenter extends BasePresenter<MainView> implements Observer<ForecastResponse> {

    @Inject
    protected ForecastMapper mForecastMapper;

    @Inject
    protected ApiService mApiService;

    @Inject
    public ForecastPresenter() {

    }

    public void getForecast() {
        getView().onShowDialog("Загрузка прогнозов...");
        Observable<ForecastResponse> forecastResponseObservable = mApiService.getListForecastRx();
        subscribe(forecastResponseObservable, this);

    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Загрузка прогнозов закончена!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Ошибка загрузки прогнозов " + e.getMessage());
    }

    @Override
    public void onNext(ForecastResponse forecastResponse) {
        List<Forecast> forecasts = mForecastMapper.mapForecasts(forecastResponse);
        getView().onForecastLoaded(forecasts);
    }
}
