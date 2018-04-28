package com.example.admin.filmsclient.presentation.ui.filmdetail.pages.overview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.filmsclient.Const;
import com.example.admin.filmsclient.GlideApp;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;
import com.example.admin.filmsclient.utils.ApiUtils;

import butterknife.BindView;

public class OverviewFragment extends BaseFragment {

    @BindView(R.id.text_view_title)
    TextView textViewTitle;

    @BindView(R.id.text_view_description)
    TextView textViewDescription;

    @BindView(R.id.text_view_date)
    TextView textViewDate;

    @BindView(R.id.image_view_poster)
    ImageView imageViewPoster;

    FilmDetailModel filmDetailModel;

    public static OverviewFragment newInstance(FilmDetailModel filmDetailModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Const.EXTRA_FILM_MODEL, filmDetailModel);
        OverviewFragment fragment = new OverviewFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_overview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filmDetailModel = getArguments().getParcelable(Const.EXTRA_FILM_MODEL);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fillContent(filmDetailModel);
    }

    private void fillContent(FilmDetailModel filmDetailModel) {
        textViewTitle.setText(filmDetailModel.getTitle());
        textViewDescription.setText(filmDetailModel.getOverview());
        textViewDate.setText(filmDetailModel.getReleaseDate());
        GlideApp.with(this)
                .asBitmap()
                .placeholder(R.drawable.ic_error_outline_black_24dp)
                .load(ApiUtils.getBackPoster(filmDetailModel.getPosterPath()))
                .into(imageViewPoster);
    }
}
