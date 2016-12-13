package com.example.koidev.mvp_dagger_rx.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.koidev.mvp_dagger_rx.application.ForecastApplication;
import com.example.koidev.mvp_dagger_rx.dagger.components.ApplicationComponent;

import butterknife.ButterKnife;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //не понимаю этого, что-то связано с сохранением состояния?
        setContentView(getContentView());
        ButterKnife.bind(this);
        onViewReady(savedInstanceState, getIntent());
    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //To be used by child activities
        resolveDaggerDependency();
    }

    protected void resolveDaggerDependency() {

    }

    protected void showDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((ForecastApplication) getApplication()).getApplicationComponent();
    }

    protected abstract int getContentView();
}
