package com.example.admin.filmsclient.domain.premiers;

import com.example.admin.filmsclient.domain.core.pojo.Movie;

import io.reactivex.Single;

public interface PremiersRepository {

    Single<Movie> getMovie();
}
