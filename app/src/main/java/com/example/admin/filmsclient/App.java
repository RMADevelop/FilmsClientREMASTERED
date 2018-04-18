package com.example.admin.filmsclient;

import android.app.Application;

import com.example.admin.filmsclient.di.ComponentManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ComponentManager.getComponentManager()
                .initComponentManager(this);
    }
}
