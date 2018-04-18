package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.repositories.premiers.PremiersDataRepository;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.domain.premiers.PremiersRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PremiersModule {

    @Binds
    @UserScope
    abstract PremiersRepository providePremiersRepository(PremiersDataRepository premiersDataRepository);
}
