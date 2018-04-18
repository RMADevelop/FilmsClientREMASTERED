package com.example.admin.filmsclient.presentation.mvp.premiers;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.domain.core.pojo.Movie;
import com.example.admin.filmsclient.domain.premiers.PremiersInteractor;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

@InjectViewState
public class PremiersPresenter extends BasePresenter<PremiersView> {

    private final PremiersInteractor premiersInteractor;

    @Inject
    public PremiersPresenter(PremiersInteractor premiersInteractor) {
        this.premiersInteractor = premiersInteractor;
    }


    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getMovie();
    }

    public void getMovie() {
        premiersInteractor.getMovie()
                .subscribeWith(new DisposableSingleObserver<Movie>() {
                    @Override
                    public void onSuccess(Movie movie) {
                        Log.d("dfsfsdf", "onSuccess: " + movie.getResults().size());
                        getViewState().setItems(movie.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
