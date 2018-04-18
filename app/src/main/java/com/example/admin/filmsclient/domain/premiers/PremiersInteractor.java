package com.example.admin.filmsclient.domain.premiers;

import com.example.admin.filmsclient.domain.core.pojo.Movie;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PremiersInteractor {

    private final PremiersRepository premiersRepository;

    @Inject
    public PremiersInteractor(PremiersRepository premiersRepository) {
        this.premiersRepository = premiersRepository;
    }

    public Single<Movie> getMovie() {
        return premiersRepository.getMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
