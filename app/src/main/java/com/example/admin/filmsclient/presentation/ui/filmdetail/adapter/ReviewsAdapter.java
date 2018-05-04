package com.example.admin.filmsclient.presentation.ui.filmdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.data.remote.dto.ReviewDto;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseAdapterWithHeaderFooter;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseViewHolder;

import butterknife.BindView;

public class ReviewsAdapter extends BaseAdapterWithHeaderFooter<ReviewDto, ReviewsAdapter.ReviewViewHolder> {

    public ReviewsAdapter(Context context) {
        super(context);
    }

    @Override
    protected ReviewViewHolder createItemViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.item_review, viewGroup, false);
        return new ReviewViewHolder(view);
    }

    @Override
    protected ReviewViewHolder createFooterViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    protected ReviewViewHolder createHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    protected int getHeadersCount() {
        return 0;
    }

    @Override
    protected int getFootersCount() {
        return 0;
    }

    static class ReviewViewHolder extends BaseViewHolder<ReviewDto> {

        @BindView(R.id.text_view_name)
        TextView textViewName;

        @BindView(R.id.text_view_content)
        TextView textViewContent;

        public ReviewViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(Context context) {

            textViewName.setText(getItem().getAuthor());
            textViewContent.setText(getItem().getContent());
        }
    }
}
