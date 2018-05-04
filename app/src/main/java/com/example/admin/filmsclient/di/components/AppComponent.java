package com.example.admin.filmsclient.di.components;

import com.example.admin.filmsclient.di.modules.AppModule;
import com.example.admin.filmsclient.di.modules.CommonNetworkModule;
import com.example.admin.filmsclient.di.modules.NavigationModule;
import com.example.admin.filmsclient.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        CommonNetworkModule.class,
//        AuthNetworkModule.class,
        NavigationModule.class
})
@Singleton
public interface AppComponent {

    MainComponent plusMainComponent();

    PremiersComponent plusPremiersComponent();

    FilmDetailComponent plusFilmDetailComponent();

    CreditsComponent plusCreditsComponent();
}
