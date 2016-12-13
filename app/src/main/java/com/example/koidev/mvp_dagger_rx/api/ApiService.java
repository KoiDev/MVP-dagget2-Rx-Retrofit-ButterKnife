package com.example.koidev.mvp_dagger_rx.api;


import com.example.koidev.mvp_dagger_rx.mvp.model.ForecastResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public interface ApiService {

    @GET("feed_android_test.php?action=get_search_result")
    Observable<ForecastResponse> getListForecastRx();


}
