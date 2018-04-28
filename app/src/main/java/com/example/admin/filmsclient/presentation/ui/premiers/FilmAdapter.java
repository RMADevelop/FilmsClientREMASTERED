package com.example.admin.filmsclient.presentation.ui.premiers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.filmsclient.GlideApp;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.ResultModel;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseAdapterWithHeaderFooter;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseViewHolder;
import com.example.admin.filmsclient.utils.ApiUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class FilmAdapter extends BaseAdapterWithHeaderFooter<ResultModel, FilmAdapter.ViewHolder> {

    private final PremiersAdapterListener listener;
    Fragment fragment;
    private boolean showFooter;

    public FilmAdapter(Context context, PremiersAdapterListener listener, Fragment fragment) {
        super(context);
        this.listener = listener;
        this.fragment = fragment;
    }

    @Override
    protected ViewHolder createItemViewHolder(ViewGroup viewGroup, int viewType) {

        View view = inflater.inflate(R.layout.item_film_card_max, viewGroup, false);
        return new PremiersViewHolder(view, fragment, listener);
    }

    @Override
    protected ViewHolder createFooterViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_footer, viewGroup, false);
        return new FooterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (showFooter && position == getItemCount() - 1 && getItemCount() > 1) {
            listener.loadMore();
        }
    }

    @Override
    protected PremiersViewHolder createHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    protected int getHeadersCount() {
        return 0;
    }

    @Override
    protected int getFootersCount() {
        return showFooter ? 1 : 0;
    }

    public void setFooterState(boolean footerState) {
        showFooter = footerState;
    }

    public interface PremiersAdapterListener {
        void onItemClick(ResultModel resultModel);

        void loadMore();
    }

    abstract static class ViewHolder extends BaseViewHolder<ResultModel> {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class PremiersViewHolder extends ViewHolder {
        PremiersAdapterListener listener;
        Context context;
        Fragment fragment;

        @BindView(R.id.card_view_container)
        CardView cardViewContainer;

        @BindView(R.id.text_view_title_film)
        TextView textViewTitleFilm;

        @BindView(R.id.text_view_date)
        TextView textViewDate;

        @BindView(R.id.text_view_rating)
        TextView textViewRating;

        @BindView(R.id.text_view_description)
        TextView textViewDescription;

        @BindView(R.id.image_view_poster)
        ImageView imageViewPoster;

        public PremiersViewHolder(View itemView, Fragment fragment, PremiersAdapterListener listener) {
            super(itemView);
            this.fragment = fragment;
            this.listener = listener;
        }

        @Override
        protected void bind(Context context) {
            textViewTitleFilm.setText(getItem().getTitle());
            textViewDate.setText(getItem().getReleaseDate());
            textViewRating.setText(String.valueOf(getItem().getVoteAverage()));
            textViewDescription.setText(getItem().getOverview());

            GlideApp.with(fragment)
                    .asBitmap()
                    .load(ApiUtils.getPathPoster(getItem().getPosterPath()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_error_outline_black_24dp)
                    .into(imageViewPoster);
        }


        @OnClick(R.id.card_view_container)
        void itemClick() {
            listener.onItemClick(getItem());
        }
    }

    public static class FooterViewHolder extends ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(Context context) {

        }
    }
}
