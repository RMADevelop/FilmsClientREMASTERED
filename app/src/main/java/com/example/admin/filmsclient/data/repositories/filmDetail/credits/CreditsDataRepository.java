package com.example.admin.filmsclient.data.repositories.filmDetail.credits;

import com.example.admin.filmsclient.data.remote.Server;
import com.example.admin.filmsclient.data.remote.dto.CreditsDto;
import com.example.admin.filmsclient.domain.filmDetail.credits.CreditsRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class CreditsDataRepository implements CreditsRepository {

    private final Server server;

    @Inject
    public CreditsDataRepository(Server server) {
        this.server = server;
    }

    @Override
    public Single<CreditsDto> getCredits(int idFilm) {
        return server.getFilmsCredits(idFilm);
    }
}
