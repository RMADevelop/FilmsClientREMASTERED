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
import com.example.admin.filmsclient.data.remote.dto.CastDto;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.models.FilmDetailModel;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits.CreditsPresenter;
import com.example.admin.filmsclient.presentation.mvp.filmDetail.pages.credits.CreditsView;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;
import com.example.admin.filmsclient.presentation.ui.filmdetail.adapter.CreditsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class CreditsFragment extends BaseFragment implements CreditsView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @InjectPresenter
    CreditsPresenter creditsPresenter;
    private FilmDetailModel filmDetailModel;
    private CreditsAdapter adapter;

    public static CreditsFragment newInstance(FilmDetailModel filmDetailModel) {
        CreditsFragment fragment = new CreditsFragment();
        Bundle args = new Bundle();
        args.putParcelable(Const.EXTRA_FILM_MODEL, filmDetailModel);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    CreditsPresenter providePresenter() {
        return ComponentManager.getComponentManager()
                .plusCreditsComponent()
                .providePresenter();
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
        initRecyclerView();
        creditsPresenter.getCredits(filmDetailModel.getId());
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CreditsAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_credits;
    }

    @Override
    public void showContent(List<CastDto> castList) {
        adapter.addItems(castList);
    }
}
