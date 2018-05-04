package com.example.admin.filmsclient.domain.filmDetail;

import com.example.admin.filmsclient.data.remote.dto.ReviewsDto;
import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;

import io.reactivex.Single;

public interface FilmDetailRepository {

    Single<FilmDetail> getFilmInfo(int id);

    Single<ReviewsDto> getReviews(int id);
}
