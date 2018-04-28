package com.example.admin.filmsclient.data.repositories.filmDetail;

import com.example.admin.filmsclient.data.remote.Server;
import com.example.admin.filmsclient.data.remote.mappers.FilmDetailDtoMapper;
import com.example.admin.filmsclient.domain.core.pojo.FilmDetail;
import com.example.admin.filmsclient.domain.filmDetail.FilmDetailRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class FilmDetailDataRepository implements FilmDetailRepository {

    private final Server server;
    private final FilmDetailDtoMapper filmDetailDtoMapper;

    @Inject
    public FilmDetailDataRepository(Server server, FilmDetailDtoMapper filmDetailDtoMapper) {
        this.server = server;
        this.filmDetailDtoMapper = filmDetailDtoMapper;
    }

    @Override
    public Single<FilmDetail> getFilmInfo(int id) {
        return server.getFilmInfo(id)
                .map(filmDetailDtoMapper::map);
    }
}
