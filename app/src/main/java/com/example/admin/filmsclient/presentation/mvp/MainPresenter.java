package com.example.admin.filmsclient.presentation.mvp;

import android.util.Log;

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
        Log.d("sdfsdfffs", "onFirstViewAttach: ");
        router.navigateTo(Screens.PREMIERS);
    }
}
