package com.example.admin.filmsclient.presentation.mvp.premiers;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.domain.premiers.PremiersInteractor;
import com.example.admin.filmsclient.presentation.Screens;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;
import com.example.admin.filmsclient.presentation.mvp.core.mappers.MovieStateMapper;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.FilmDetailPresenter;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.MovieModel;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class PremiersPresenter extends BasePresenter<PremiersView> {

    private final PremiersInteractor premiersInteractor;
    private final MovieStateMapper movieStateMapper;
    private final Router router;

    @Inject
    public PremiersPresenter(PremiersInteractor premiersInteractor, MovieStateMapper movieStateMapper, Router router) {
        this.premiersInteractor = premiersInteractor;
        this.movieStateMapper = movieStateMapper;
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getMovie();
    }

    public void getMovie() {
        premiersInteractor.getMovie()
                .map(movieStateMapper::map)
                .subscribeWith(new DisposableSingleObserver<MovieModel>() {
                    @Override
                    public void onSuccess(MovieModel movieModel) {
                        getViewState().setItems(movieModel.getResults());
                        getViewState().setStateItems(movieModel.isHasNext());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    public void onItemClick(ResultModel resultModel) {
        getViewState().openFilmDetail(resultModel.getId());
    }

    public void openFragment(int id) {
        FilmDetailPresenter.Params params = FilmDetailPresenter.Params.builder()
                .id(id)
                .build();

        router.navigateTo(Screens.FILM_DETAIL, params);
    }
}
