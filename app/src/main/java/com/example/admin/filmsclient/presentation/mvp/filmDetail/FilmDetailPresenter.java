package com.example.admin.filmsclient.presentation.mvp.filmDetail;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.domain.filmDetail.FilmDetailInteractor;
import com.example.admin.filmsclient.presentation.Screens;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;
import com.example.admin.filmsclient.presentation.mvp.core.mappers.FilmDetailMapper;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import lombok.Builder;
import lombok.Getter;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class FilmDetailPresenter extends BasePresenter<FilmDetailView> {

    private final FilmDetailInteractor filmDetailInteractor;

    private final FilmDetailMapper filmDetailMapper;

    private final Router router;

    @Inject
    public FilmDetailPresenter(FilmDetailInteractor filmDetailInteractor, FilmDetailMapper filmDetailMapper, Router router) {
        this.filmDetailInteractor = filmDetailInteractor;
        this.filmDetailMapper = filmDetailMapper;
        this.router = router;
    }

    public void showContent(int id) {
        filmDetailInteractor.getFilmInfo(id)
                .subscribeOn(Schedulers.io())
                .map(filmDetailMapper::map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<FilmDetailModel>() {
                    @Override
                    public void onSuccess(FilmDetailModel filmDetailModel) {
                        getViewState().fillContent(filmDetailModel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    public void navigationIconClick() {
        router.backTo(Screens.PREMIERS);
    }

    @Builder
    public static class Params {

        @Getter
        private int id;
    }
}
