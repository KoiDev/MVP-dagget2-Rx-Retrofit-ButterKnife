package com.example.koidev.mvp_dagger_rx.modules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Valentin Baryshev.
 */

public class ForecastFragmentActivity extends SingleFragmentNavigationActivity {

    public static void start(Activity activity) {
        Intent starter = new Intent(activity, ForecastFragmentActivity.class);
        activity.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSingleFragment(ForecastFragment.newInstance(), "Forecast");
    }
}
