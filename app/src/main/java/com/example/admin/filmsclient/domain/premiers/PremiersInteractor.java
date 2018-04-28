package com.example.admin.filmsclient.domain.premiers;

import android.util.Log;

import com.example.admin.filmsclient.domain.PaginationState;
import com.example.admin.filmsclient.domain.core.pojo.Movie;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PremiersInteractor {

    private final PremiersRepository premiersRepository;
    private final PaginationState paginationState;

    @Inject
    public PremiersInteractor(PremiersRepository premiersRepository, PaginationState paginationState) {
        this.premiersRepository = premiersRepository;
        this.paginationState = paginationState;
    }

    public Single<Movie> getMovie() {
        return premiersRepository.getMovie(paginationState.getPage())
                .doOnSuccess(movie -> paginationState.nextPage())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
