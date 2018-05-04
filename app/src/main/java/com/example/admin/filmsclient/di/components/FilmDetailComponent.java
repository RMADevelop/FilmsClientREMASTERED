package com.example.admin.filmsclient.di.components;

import com.example.admin.filmsclient.di.modules.FilmDetailModule;
import com.example.admin.filmsclient.di.scope.UserScope;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.FilmDetailPresenter;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.reviews.ReviewsPresenter;

import dagger.Subcomponent;

@Subcomponent(modules = {
        FilmDetailModule.class
})
@UserScope
public interface FilmDetailComponent {

    FilmDetailPresenter provideFilmDetailPresenter();

    ReviewsPresenter provideReviewsPresenter();

}
