package com.example.admin.filmsclient.presentation.ui.filmdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.filmsclient.Const;
import com.example.admin.filmsclient.GlideApp;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.FilmDetailPresenter;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.FilmDetailView;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;
import com.example.admin.filmsclient.presentation.ui.filmdetail.adapter.PagesAdapter;
import com.example.admin.filmsclient.utils.ApiUtils;

import butterknife.BindView;

public class FilmDetailFragment extends BaseFragment implements FilmDetailView {

    @BindView(R.id.image_view_poster)
    ImageView imageViewPosterBack;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @InjectPresenter
    FilmDetailPresenter presenter;

    private PagesAdapter pagesAdapter;

    private int idFilm;

    public static FilmDetailFragment newInstance(FilmDetailPresenter.Params paramsFilmDetail) {

        Bundle args = new Bundle();
        args.putInt(Const.EXTRA_FILM_ID, paramsFilmDetail.getId());
        FilmDetailFragment fragment = new FilmDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    FilmDetailPresenter providePresenter() {
        return ComponentManager.getComponentManager()
                .plusFilmDetailComponent()
                .provideFilmDetailPresenter();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_film_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            idFilm = getArguments().getInt(Const.EXTRA_FILM_ID);

            Log.d("sdfsdf", "onCreate: " + idFilm);
        }
    }

    @Override
    protected void setupToolbar(Toolbar toolbar) {
        setToolbarNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> presenter.navigationIconClick());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUi(view);
        presenter.showContent(idFilm);
    }

    private void initUi(View view) {

    }


    @Override
    public void fillContent(FilmDetailModel filmDetailModel) {
        GlideApp.with(this)
                .asBitmap()
                .placeholder(R.drawable.ic_error_outline_black_24dp)
                .load(ApiUtils.getBackPoster(filmDetailModel.getBackdropPath()))
                .into(imageViewPosterBack);

        pagesAdapter = new PagesAdapter(getChildFragmentManager(), filmDetailModel);
        viewPager.setAdapter(pagesAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
