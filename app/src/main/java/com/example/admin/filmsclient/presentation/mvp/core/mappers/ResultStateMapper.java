package com.example.admin.filmsclient.presentation.mvp.core.mappers;

import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.Result;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;

import javax.inject.Inject;

public class ResultStateMapper extends BaseMappers<Result, ResultModel> {

    @Inject
    public ResultStateMapper() {
    }

    @Override
    public ResultModel map(Result result) {
        return ResultModel.builder()
                .adult(result.isAdult())
                .backdropPath(result.getBackdropPath())
                .genreIds(result.getGenreIds())
                .id(result.getId())
                .originalLanguage(result.getOriginalLanguage())
                .originalTitle(result.getOriginalTitle())
                .overview(result.getOverview())
                .popularity(result.getPopularity())
                .posterPath(result.getPosterPath())
                .releaseDate(result.getReleaseDate())
                .title(result.getTitle())
                .voteAverage(result.getVoteAverage())
                .voteCount(result.getVoteCount())
                .build();
    }
}
