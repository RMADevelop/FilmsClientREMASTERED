package com.example.admin.filmsclient.presentation.mvp.premiers;

import com.arellomobile.mvp.MvpView;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.MovieModel;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;

import java.util.List;

public interface PremiersView extends MvpView {

    void setItems(List<ResultModel> movieModel);

    void setStateItems(boolean hasNext);

    void openFilmDetail(int id);
}
