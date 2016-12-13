package com.example.koidev.mvp_dagger_rx.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author KoiDev
 * @email DevSteelKoi@gmail.com
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
