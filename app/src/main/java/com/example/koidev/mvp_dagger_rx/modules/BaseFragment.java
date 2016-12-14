package com.example.koidev.mvp_dagger_rx.modules;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.koidev.mvp_dagger_rx.application.ForecastApplication;
import com.example.koidev.mvp_dagger_rx.dagger.components.ApplicationComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDaggerDependency();
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((ForecastApplication) getActivity().getApplication()).getApplicationComponent();
    }

    protected abstract int getLayoutId();

    protected abstract void resolveDaggerDependency();
}
