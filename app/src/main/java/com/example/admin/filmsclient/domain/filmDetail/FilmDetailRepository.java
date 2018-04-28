package com.example.admin.filmsclient.domain.filmDetail;

import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;

import io.reactivex.Single;

public interface FilmDetailRepository {

    Single<FilmDetail> getFilmInfo(int id);
}
