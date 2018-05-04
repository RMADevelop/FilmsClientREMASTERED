package com.example.admin.filmsclient;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.admin.filmsclient.presentation.Screens;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.FilmDetailPresenter;
import com.example.admin.filmsclient.presentation.ui.filmdetail.FilmDetailFragment;
import com.example.admin.filmsclient.presentation.ui.premiers.PremiersFragment;

import ru.terrakok.cicerone.android.SupportAppNavigator;

public class AppNavigator extends SupportAppNavigator {

    private final FragmentManager fragmentManager;
    private final FragmentActivity fragmentActivity;

    public AppNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(activity, fragmentManager, containerId);
        this.fragmentManager = fragmentManager;
        this.fragmentActivity = activity;
    }

    @Override
    protected Intent createActivityIntent(Context context, String screenKey, Object data) {
        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.PREMIERS:
                return PremiersFragment.newInstance();
            case Screens.FILM_DETAIL:
                return FilmDetailFragment.newInstance((FilmDetailPresenter.Params) data);
        }
        return null;
    }

    private Fragment getFragment(Fragment fragment/*, Bundle bundle*/) {
//        fragment.setArguments(bundle);
        return fragment;
    }

}
