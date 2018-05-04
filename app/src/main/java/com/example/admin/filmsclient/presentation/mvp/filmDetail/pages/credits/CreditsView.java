package com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.admin.filmsclient.data.remote.dto.CastDto;

import java.util.List;

public interface CreditsView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showContent(List<CastDto> castList);
}
