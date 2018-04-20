package com.example.admin.filmsclient.data.repositories.premiers;

import com.example.admin.filmsclient.data.remote.Server;
import com.example.admin.filmsclient.data.remote.mappers.MovieDtoMapper;
import com.example.admin.filmsclient.domain.core.pojo.Movie;
import com.example.admin.filmsclient.domain.premiers.PremiersRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class PremiersDataRepository implements PremiersRepository {

    private final Server server;
    private final MovieDtoMapper movieDtoMapper;

    @Inject
    public PremiersDataRepository(Server server, MovieDtoMapper movieDtoMapper) {
        this.server = server;
        this.movieDtoMapper = movieDtoMapper;
    }


    @Override
    public Single<Movie> getMovie(int page) {
        return server.getMovie(String.valueOf(page))
                .map(movieDtoMapper::map);
    }
}
