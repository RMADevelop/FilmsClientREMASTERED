package com.example.admin.filmsclient.di.components;

import com.example.admin.filmsclient.di.modules.MainModule;
import com.example.admin.filmsclient.presentation.mvp.MainPresenter;
import com.example.admin.filmsclient.presentation.ui.MainActivity;

import dagger.Subcomponent;


@Subcomponent(modules = {
        MainModule.class
})

public interface MainComponent {

    MainPresenter providePresenter();

    void inject(MainActivity mainActivity);
}
