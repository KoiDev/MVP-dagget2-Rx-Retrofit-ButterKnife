package com.example.koidev.mvp_dagger_rx.mapper;

import com.example.koidev.mvp_dagger_rx.mvp.model.Forecast;
import com.example.koidev.mvp_dagger_rx.mvp.model.ForecastResponse;
import com.example.koidev.mvp_dagger_rx.mvp.model.ForecastResponseData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public class ForecastMapper {

    @Inject
    public ForecastMapper() {
    }

    public List<Forecast> mapForecasts(ForecastResponse response) {

        List<Forecast> forecastList = new ArrayList<>();

        if (forecastList != null) {
            ForecastResponseData[] forecastResponseDatas = response.getData();
            if (forecastResponseDatas != null) {
                for (ForecastResponseData forecast : forecastResponseDatas) {

                    Forecast myForecast = new Forecast();
                    myForecast.setDate(forecast.getDate());
                    myForecast.setDate_add(forecast.getDate_add());
                    myForecast.setResult(forecast.getResult());
                    myForecast.setUid(forecast.getUid());
                    myForecast.setAuthor(forecast.getAuthor());
                    myForecast.setLeague(forecast.getLeague());
                    myForecast.setOdds(forecast.getOdds());
                    myForecast.setRating(forecast.getRating());
                    myForecast.setId(forecast.getId());
                    myForecast.setKf(forecast.getKf());
                    myForecast.setCommand(forecast.getCommand());

                    forecastList.add(myForecast);
                }
            }
        }
        return forecastList;
    }
}
