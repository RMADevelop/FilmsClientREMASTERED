package com.example.admin.filmsclient.domain.filmDetail.credits;

import com.example.admin.filmsclient.data.remote.dto.CreditsDto;

import javax.inject.Inject;

import io.reactivex.Single;

public class CreditsInteractor {

    private final CreditsRepository creditsRepository;

    @Inject
    public CreditsInteractor(CreditsRepository creditsRepository) {
        this.creditsRepository = creditsRepository;
    }

    public Single<CreditsDto> getCredits(int idFilm) {
        return creditsRepository.getCredits(idFilm);
    }
}
