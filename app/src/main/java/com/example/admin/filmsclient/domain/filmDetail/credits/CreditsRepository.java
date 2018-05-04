package com.example.admin.filmsclient.domain.filmDetail.credits;

import com.example.admin.filmsclient.data.remote.dto.CreditsDto;

import io.reactivex.Single;

public interface CreditsRepository {
    Single<CreditsDto> getCredits(int idFilm);
}
