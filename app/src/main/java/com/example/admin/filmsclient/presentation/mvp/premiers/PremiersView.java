package com.example.admin.filmsclient.presentation.mvp.premiers;

import com.arellomobile.mvp.MvpView;
import com.example.admin.filmsclient.domain.core.pojo.Result;

import java.util.List;

public interface PremiersView extends MvpView {

    void setItems(List<Result> list);
}
