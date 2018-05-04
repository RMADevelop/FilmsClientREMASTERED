package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.repositories.filmDetail.credits.CreditsDataRepository;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.domain.filmDetail.credits.CreditsRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CreditsModule {

    @Binds
    @UserScope
    abstract CreditsRepository provideCreditsRepository(CreditsDataRepository creditsDataRepository);
}
