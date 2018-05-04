package com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.reviews;

import com.arellomobile.mvp.InjectViewState;
import com.example.admin.filmsclient.data.remote.dto.ReviewsDto;
import com.example.admin.filmsclient.domain.filmDetail.FilmDetailInteractor;
import com.example.admin.filmsclient.presentation.mvp.core.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class ReviewsPresenter extends BasePresenter<ReviewsView> {

    private final FilmDetailInteractor filmDetailInteractor;

    @Inject
    public ReviewsPresenter(FilmDetailInteractor filmDetailInteractor) {
        this.filmDetailInteractor = filmDetailInteractor;
    }

    public void getReviews(int idFilm) {
        filmDetailInteractor.getReviews(idFilm)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ReviewsDto>() {
                    @Override
                    public void onSuccess(ReviewsDto reviewsDto) {
                        getViewState().showReviews(reviewsDto.getListReview());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
