package com.example.admin.filmsclient.presentation.ui.premiers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.di.ComponentManager;
import com.example.admin.filmsclient.presentation.mvp.premiers.PremiersPresenter;
import com.example.admin.filmsclient.presentation.mvp.premiers.PremiersView;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;

import java.util.List;

import butterknife.BindView;

public class PremiersFragment extends BaseFragment implements PremiersView, FilmAdapter.PremiersAdapterListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    FilmAdapter filmAdapter;
    @InjectPresenter
    PremiersPresenter premiersPresenter;

    private PremiersFragmentListener listener;


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
        toolbar.setTitle("TestTitle");
        toolbar.setNavigationIcon(R.drawable.ic_back);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PremiersFragmentListener) {
            listener = (PremiersFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        filmAdapter = new FilmAdapter(getContext(), this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(filmAdapter);
    }

    @Override
    public void setItems(List<ResultModel> resultModel) {
        Log.d("dsfsdf", "setItems: ");
        filmAdapter.addItems(resultModel);
    }

    @Override
    public void setStateItems(boolean hasNext) {
        filmAdapter.setFooterState(hasNext);
    }

    @Override
    public void openFilmDetail(int id) {
        premiersPresenter.openFragment(id);
    }

    @Override
    public void onItemClick(ResultModel resultModel) {
        premiersPresenter.openFragment(resultModel.getId());
    }

    @Override
    public void loadMore() {
        premiersPresenter.getMovie();
    }

    public interface PremiersFragmentListener {
        void openFragment(int id);
    }
}
