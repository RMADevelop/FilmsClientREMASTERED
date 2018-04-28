package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.repositories.filmDetail.FilmDetailDataRepository;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.domain.filmDetail.FilmDetailRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FilmDetailModule {

    @Binds
    @UserScope
    abstract FilmDetailRepository provideFilmDetailRepository(FilmDetailDataRepository filmDetailDataRepository);
}
