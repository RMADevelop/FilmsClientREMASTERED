package com.example.admin.filmsclient.presentation.mvp;

import android.os.Bundle;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.presentation.Screens;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    private final Router router;

    @Inject
    public MainPresenter(Router router) {
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.navigateTo(Screens.PREMIERS);
    }

    public void openFilmDetail(Bundle bundle) {
        router.navigateTo(Screens.FILM_DETAIL, bundle);
    }
}
