package com.example.admin.filmsclient.presentation.mvp.core.mappers;

import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;

import javax.inject.Inject;

public class FilmDetailMapper extends BaseMappers<FilmDetail, FilmDetailModel> {

    @Inject
    public FilmDetailMapper() {
    }

    @Override
    public FilmDetailModel map(FilmDetail filmDetail) {
        return FilmDetailModel.builder()
                .adult(filmDetail.isAdult())
                .backdropPath(filmDetail.getBackdropPath())
                .budget(filmDetail.getBudget())
                .imdbId(filmDetail.getImdbId())
                .id(filmDetail.getId())
                .originalLanguage(filmDetail.getOriginalLanguage())
                .originalTitle(filmDetail.getOriginalTitle())
                .overview(filmDetail.getOverview())
                .popularity(filmDetail.getPopularity())
                .posterPath(filmDetail.getPosterPath())
                .releaseDate(filmDetail.getReleaseDate())
                .revenue(filmDetail.getRevenue())
                .runtime(filmDetail.getRuntime())
                .status(filmDetail.getStatus())
                .tagline(filmDetail.getTagline())
                .title(filmDetail.getTitle())
                .video(filmDetail.isVideo())
                .voteAverage(filmDetail.getVoteAverage())
                .voteCount(filmDetail.getVoteCount())
                .build();
    }
}
