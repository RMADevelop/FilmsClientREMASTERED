package com.example.admin.filmsclient.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application applicationContext;

    public AppModule(Application applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return applicationContext;
    }
}
