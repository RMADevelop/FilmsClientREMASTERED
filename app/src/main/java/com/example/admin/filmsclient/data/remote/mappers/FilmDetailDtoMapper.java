package com.example.admin.filmsclient.data.remote.mappers;

import com.example.admin.filmsclient.data.remote.dto.FilmDetailDto;
import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;

import javax.inject.Inject;

public class FilmDetailDtoMapper extends BaseMappers<FilmDetailDto, FilmDetail> {


    @Inject
    public FilmDetailDtoMapper() {
    }

    @Override
    public FilmDetail map(FilmDetailDto filmDetailDto) {
        return FilmDetail.builder()
                .adult(filmDetailDto.isAdult())
                .backdropPath(filmDetailDto.getBackdropPath())
                .budget(filmDetailDto.getBudget())
                .imdbId(filmDetailDto.getImdbId())
                .id(filmDetailDto.getId())
                .originalLanguage(filmDetailDto.getOriginalLanguage())
                .originalTitle(filmDetailDto.getOriginalTitle())
                .overview(filmDetailDto.getOverview())
                .popularity(filmDetailDto.getPopularity())
                .posterPath(filmDetailDto.getPosterPath())
                .releaseDate(filmDetailDto.getReleaseDate())
                .revenue(filmDetailDto.getRevenue())
                .runtime(filmDetailDto.getRuntime())
                .status(filmDetailDto.getStatus())
                .tagline(filmDetailDto.getTagline())
                .title(filmDetailDto.getTitle())
                .video(filmDetailDto.isVideo())
                .voteAverage(filmDetailDto.getVoteAverage())
                .voteCount(filmDetailDto.getVoteCount())
                .build();
    }
}
