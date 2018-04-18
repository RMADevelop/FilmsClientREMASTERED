package com.example.admin.filmsclient.data.remote.mappers;

import com.example.admin.filmsclient.data.remote.dto.ResultDto;
import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.Result;

import javax.inject.Inject;

public class ResultDtoMapper extends BaseMappers<ResultDto, Result> {

    @Inject
    public ResultDtoMapper() {
    }

    @Override
    public Result map(ResultDto resultDto) {
        return Result.builder()
                .adult(resultDto.isAdult())
                .backdropPath(resultDto.getBackdropPath())
                .genreIds(resultDto.getGenreIds())
                .id(resultDto.getId())
                .originalLanguage(resultDto.getOriginalLanguage())
                .originalTitle(resultDto.getOriginalTitle())
                .overview(resultDto.getOverview())
                .popularity(resultDto.getPopularity())
                .posterPath(resultDto.getPosterPath())
                .releaseDate(resultDto.getReleaseDate())
                .title(resultDto.getTitle())
                .voteAverage(resultDto.getVoteAverage())
                .video(resultDto.isVideo())
                .voteCount(resultDto.getVoteCount())
                .build();
    }
}
