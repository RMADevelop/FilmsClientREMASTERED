package com.example.admin.filmsclient.presentation.ui;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.filmsclient.AppNavigator;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.presentation.mvp.MainPresenter;
import com.example.admin.filmsclient.presentation.mvp.MainView;
import com.example.admin.filmsclient.presentation.ui.core.BaseActivity;

import javax.inject.Inject;
import javax.inject.Provider;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;


public class MainActivity extends BaseActivity implements MainView {

    private final AppNavigator navigator = new AppNavigator(this,
            getSupportFragmentManager(),
            R.id.main_container);

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Provider<MainPresenter> provider;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return provider.get();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ComponentManager
                .getComponentManager()
                .plusMainComponent()
                .inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(getNavigator());
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    protected Navigator getNavigator() {
        return navigator;
    }
}
