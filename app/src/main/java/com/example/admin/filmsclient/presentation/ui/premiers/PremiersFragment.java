package com.example.admin.filmsclient.presentation.ui.premiers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.domain.core.pojo.Result;
import com.example.admin.filmsclient.presentation.mvp.premiers.PremiersPresenter;
import com.example.admin.filmsclient.presentation.mvp.premiers.PremiersView;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class PremiersFragment extends BaseFragment implements PremiersView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    FilmAdapter filmAdapter;

    @InjectPresenter
    PremiersPresenter premiersPresenter;

    @ProvidePresenter
    PremiersPresenter premiersPresenter() {
        return ComponentManager.getComponentManager()
                .plusPremiersComponent()
                .providePresenter();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void setupToolbar(Toolbar toolbar) {
        toolbar.setTitle("TestTitt;le");
        toolbar.setNavigationIcon(R.drawable.ic_back);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        filmAdapter = new FilmAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(filmAdapter);
    }

    @Override
    public void setItems(List<Result> list) {
        filmAdapter.setItems(list);
    }
}
