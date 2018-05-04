package com.example.admin.filmsclient.domain.filmDetail;

import com.example.admin.filmsclient.data.remote.dto.ReviewsDto;
import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;

import javax.inject.Inject;

import io.reactivex.Single;

public class FilmDetailInteractor {

    private final FilmDetailRepository filmDetailRepository;

    @Inject
    public FilmDetailInteractor(FilmDetailRepository filmDetailRepository) {
        this.filmDetailRepository = filmDetailRepository;
    }

    public Single<FilmDetail> getFilmInfo(int id) {
        return filmDetailRepository.getFilmInfo(id);
    }

    public Single<ReviewsDto> getReviews(int id) {
        return filmDetailRepository.getReviews(id);
    }


}
