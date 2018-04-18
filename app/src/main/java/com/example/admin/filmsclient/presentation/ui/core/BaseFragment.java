package com.example.admin.filmsclient.presentation.ui.core;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.admin.filmsclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends MvpAppCompatFragment {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolbar(toolbar);
    }

    protected void setupToolbar(Toolbar toolbar) {
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    private void checkToolbar(Runnable runnable) {
        if (toolbar == null) {
            return;
        }
        runnable.run();
    }

    protected void setToolbarTitle(String title) {
        checkToolbar(() -> toolbar.setTitle(title));
    }

    protected void setToolbarMenu(@MenuRes int menu) {
        checkToolbar(() -> {
            toolbar.getMenu().clear();
            if (menu != 0) {
                toolbar.inflateMenu(menu);
            }
        });
    }

    protected void setToolbarNavigationIcon(@DrawableRes int icon) {
        checkToolbar(new Runnable() {
            @Override
            public void run() {
                if (icon == 0) {
                    toolbar.setNavigationIcon(null);
                } else {
                    toolbar.setNavigationIcon(icon);
                }
            }
        });
    }
}
