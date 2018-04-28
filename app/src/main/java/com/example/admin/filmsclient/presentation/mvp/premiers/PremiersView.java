package com.example.admin.filmsclient.presentation.mvp.premiers;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;

import java.util.List;

public interface PremiersView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void setItems(List<ResultModel> movieModel);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setStateItems(boolean hasNext);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void openFilmDetail(int id);
}
