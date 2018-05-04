package com.example.admin.filmsclient.presentation.ui.filmdetail.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.ui.filmdetail.pages.CreditsFragment;
import com.example.admin.filmsclient.presentation.ui.filmdetail.pages.OverviewFragment;
import com.example.admin.filmsclient.presentation.ui.filmdetail.pages.ReviewsFragment;

public class PagesAdapter extends FragmentPagerAdapter {

    private final FilmDetailModel filmDetailModel;

    public PagesAdapter(FragmentManager fm, FilmDetailModel filmDetailModel) {
        super(fm);
        this.filmDetailModel = filmDetailModel;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OverviewFragment.newInstance(filmDetailModel);
            case 1:
                return CreditsFragment.newInstance(filmDetailModel);
            case 2:
                return ReviewsFragment.newInstance(filmDetailModel);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Info";
            case 1:
                return "Actors";
            case 2:
                return "Reviews";
        }
        return "error";
    }

    @Override
    public int getCount() {
        return 3;
    }
}
