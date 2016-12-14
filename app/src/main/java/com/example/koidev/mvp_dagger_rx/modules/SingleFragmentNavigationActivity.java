package com.example.koidev.mvp_dagger_rx.modules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.koidev.mvp_dagger_rx.R;

import butterknife.BindView;

/**
 * Created by Valentin Baryshev.
 */

public class SingleFragmentNavigationActivity extends NavigationDrawerActivity {

    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_single_fragment;
    }

    protected void setSingleFragment(final Fragment fragment, final String tag) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(contentFrame.getId(), fragment, tag);
        transaction.commit();
    }

}
