package com.example.admin.filmsclient.presentation.mvp.premiers;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.domain.premiers.PremiersInteractor;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;
import com.example.admin.filmsclient.presentation.mvp.core.mappers.MovieStateMapper;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.MovieModel;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

@InjectViewState
public class PremiersPresenter extends BasePresenter<PremiersView> {

    private final PremiersInteractor premiersInteractor;
    private final MovieStateMapper movieStateMapper;
    private List<ResultModel> list;

    @Inject
    public PremiersPresenter(PremiersInteractor premiersInteractor, MovieStateMapper movieStateMapper) {
        this.premiersInteractor = premiersInteractor;
        this.movieStateMapper = movieStateMapper;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getMovie();
    }

    public void getMovie() {
        premiersInteractor.getMovie()
                .map(movieStateMapper::map)
                .doOnSuccess(movieModel -> list = movieModel.getResults())
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
}
