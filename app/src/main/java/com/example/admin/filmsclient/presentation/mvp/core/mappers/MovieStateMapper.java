package com.example.admin.filmsclient.presentation.mvp.core.mappers;

import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.Movie;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.MovieModel;

import javax.inject.Inject;

public class MovieStateMapper extends BaseMappers<Movie, MovieModel> {

    private final ResultStateMapper resultStateMapper;

    @Inject
    public MovieStateMapper(ResultStateMapper resultStateMapper) {
        this.resultStateMapper = resultStateMapper;
    }

    @Override
    public MovieModel map(Movie movie) {
        return MovieModel.builder()
                .dates(movie.getDates())
                .page(movie.getPage())
                .results(resultStateMapper.map(movie.getResults()))
                .totalPages(movie.getTotalPages())
                .hasNext(movie.getTotalPages() - movie.getPage() != 0)
                .totalResults(movie.getTotalResults())
                .build();
    }
}
