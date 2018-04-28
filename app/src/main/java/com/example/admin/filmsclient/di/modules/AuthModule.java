package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.auth.AuthHolder;
import com.example.admin.filmsclient.data.remote.AuthServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AuthModule {

    @Provides
    @Singleton
    AuthHolder provideAuthHolder(AuthServer authServer) {
        return new AuthHolder(authServer);
    }
}
