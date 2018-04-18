package com.example.admin.filmsclient.data.remote.mappers;

import com.example.admin.filmsclient.data.remote.dto.MovieDto;
import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.mappers.Mapper;
import com.example.admin.filmsclient.domain.core.pojo.Movie;

import javax.inject.Inject;


public class MovieDtoMapper extends BaseMappers<MovieDto, Movie> implements Mapper<MovieDto, Movie> {

    private final ResultDtoMapper resultDtoMapper;
    private final DatesDtoMapper datesDtoMapper;

    @Inject
    public MovieDtoMapper(ResultDtoMapper resultDtoMapper, DatesDtoMapper datesDtoMapper) {
        this.resultDtoMapper = resultDtoMapper;
        this.datesDtoMapper = datesDtoMapper;
    }

    @Override
    public Movie map(MovieDto movieDto) {
        return Movie.builder()
                .results(resultDtoMapper.map(movieDto.getResults()))
                .dates(datesDtoMapper.map(movieDto.getDates()))
                .page(movieDto.getPage())
                .totalPages(movieDto.getTotalPages())
                .totalResults(movieDto.getTotalResults())
                .build();
    }
}
