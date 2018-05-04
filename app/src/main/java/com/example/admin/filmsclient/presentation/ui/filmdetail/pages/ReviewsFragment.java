package com.example.admin.filmsclient.presentation.ui.filmdetail.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.filmsclient.Const;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.data.remote.dto.ReviewDto;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.reviews.ReviewsPresenter;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.reviews.ReviewsView;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;
import com.example.admin.filmsclient.presentation.ui.filmdetail.adapter.ReviewsAdapter;

import java.util.List;

import butterknife.BindView;

public class ReviewsFragment extends BaseFragment implements ReviewsView {

    FilmDetailModel filmDetailModel;

    @InjectPresenter
    ReviewsPresenter presenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ReviewsAdapter reviewsAdapter;

    public static ReviewsFragment newInstance(FilmDetailModel filmDetailModel) {

        Bundle args = new Bundle();
        args.putParcelable(Const.EXTRA_FILM_MODEL, filmDetailModel);
        ReviewsFragment fragment = new ReviewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    ReviewsPresenter providePresenter() {
        return ComponentManager.getComponentManager()
                .plusFilmDetailComponent()
                .provideReviewsPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filmDetailModel = getArguments().getParcelable(Const.EXTRA_FILM_MODEL);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_reviews;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
        presenter.getReviews(filmDetailModel.getId());

    }

    private void initUi() {
        reviewsAdapter = new ReviewsAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reviewsAdapter);
    }

    @Override
    public void showReviews(List<ReviewDto> listReview) {
        reviewsAdapter.addItems(listReview);
    }
}
