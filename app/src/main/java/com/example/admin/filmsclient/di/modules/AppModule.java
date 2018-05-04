package com.example.admin.filmsclient.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
