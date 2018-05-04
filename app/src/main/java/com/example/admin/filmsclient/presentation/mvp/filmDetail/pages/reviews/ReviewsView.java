package com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.reviews;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.admin.filmsclient.data.remote.dto.ReviewDto;

import java.util.List;

public interface ReviewsView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showReviews(List<ReviewDto> listReview);

}
