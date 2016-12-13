package com.example.koidev.mvp_dagger_rx.base;

import com.example.koidev.mvp_dagger_rx.mvp.view.BaseView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

public class BasePresenter<V extends BaseView> {

    @Inject
    protected V mView;

    protected V getView() {
        return mView;
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
