package com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.domain.filmDetail.credits.CreditsInteractor;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class CreditsPresenter extends BasePresenter<CreditsView> {

    private final CreditsInteractor creditsInteractor;

    @Inject
    public CreditsPresenter(CreditsInteractor creditsInteractor) {
        this.creditsInteractor = creditsInteractor;
    }

    public void getCredits(int idFilm) {
        creditsInteractor.getCredits(idFilm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(creditsDto -> getViewState().showContent(creditsDto.getCastList()),
                        Throwable::printStackTrace);

    }
}
