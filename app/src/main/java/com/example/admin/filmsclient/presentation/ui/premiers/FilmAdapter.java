package com.example.admin.filmsclient.presentation.ui.premiers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.domain.core.pojo.Result;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseAdapterWithHeaderFooter;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseViewHolder;

import butterknife.BindView;

public class FilmAdapter extends BaseAdapterWithHeaderFooter<Result, FilmAdapter.ViewHolder> {

    private boolean showFooter;

    public FilmAdapter(Context context) {
        super(context);
        list.add(Result.builder().title("TESTSETSTE").build());
    }


    @Override
    protected ViewHolder createItemViewHolder(ViewGroup viewGroup, int viewType) {

        View view = inflater.inflate(R.layout.item_film_card_max, viewGroup, false);
        return new PremiersViewHolder(view);
    }

    @Override
    protected ViewHolder createFooterViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.item_footer, viewGroup, false);
        return new FooterViewHolder(view);
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

    abstract static class ViewHolder extends BaseViewHolder<Result> {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class PremiersViewHolder extends ViewHolder {

        @BindView(R.id.text_view_title_film)
        TextView textViewTitleFilm;

        public PremiersViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(Result item, int itemPosition) {
            textViewTitleFilm.setText(item.getTitle());
        }
    }

    public static class FooterViewHolder extends ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(Result item, int itemPosition) {

        }

    }
}
