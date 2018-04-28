package com.example.admin.filmsclient.presentation.mvp.filmDetail;

import com.arellomobile.mvp.MvpView;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;

public interface FilmDetailView extends MvpView {

    void fillContent(FilmDetailModel filmDetailModel);
}
