package com.example.koidev.mvp_dagger_rx.mvp.view;

import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;

import java.util.List;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public interface MainView extends BaseView {

    void onForecastLoaded(List<Forecast> forecasts);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);
}
