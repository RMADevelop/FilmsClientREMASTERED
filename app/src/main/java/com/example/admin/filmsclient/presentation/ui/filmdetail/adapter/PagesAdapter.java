package com.example.admin.filmsclient.presentation.ui.filmdetail.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.ui.filmdetail.pages.overview.OverviewFragment;

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
                return OverviewFragment.newInstance(filmDetailModel);
            case 2:
                return OverviewFragment.newInstance(filmDetailModel);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
