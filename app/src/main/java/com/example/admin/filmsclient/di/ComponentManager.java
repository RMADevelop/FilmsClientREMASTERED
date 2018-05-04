package com.example.admin.filmsclient.di;

import android.app.Application;

import com.example.admin.filmsclient.di.components.AppComponent;
import com.example.admin.filmsclient.di.components.CreditsComponent;
import com.example.admin.filmsclient.di.components.DaggerAppComponent;
import com.example.admin.filmsclient.di.components.FilmDetailComponent;
import com.example.admin.filmsclient.di.components.MainComponent;
import com.example.admin.filmsclient.di.components.PremiersComponent;
import com.example.admin.filmsclient.di.modules.AppModule;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits.CreditsPresenter;

public class ComponentManager {
    private static ComponentManager instance;

    private AppComponent appComponent;

    private ComponentManager() {

    }

    public static ComponentManager getComponentManager() {
        if (instance == null) {
            instance = new ComponentManager();
        }
        return instance;
    }

    public void initComponentManager(Application application) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    public MainComponent plusMainComponent() {
        return appComponent.plusMainComponent();
    }

    public PremiersComponent plusPremiersComponent() {
        return appComponent.plusPremiersComponent();
    }

    public FilmDetailComponent plusFilmDetailComponent() {
        return appComponent.plusFilmDetailComponent();
    }

    public CreditsComponent plusCreditsComponent() {
        return appComponent.plusCreditsComponent();
    }

}
