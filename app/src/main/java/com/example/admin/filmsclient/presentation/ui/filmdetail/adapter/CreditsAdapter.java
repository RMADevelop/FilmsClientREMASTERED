package com.example.admin.filmsclient.presentation.ui.filmdetail.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.filmsclient.GlideApp;
import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.data.remote.dto.CastDto;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseAdapterWithHeaderFooter;
import com.example.admin.filmsclient.presentation.ui.core.adapters.BaseViewHolder;
import com.example.admin.filmsclient.utils.ApiUtils;

import butterknife.BindView;

public class CreditsAdapter extends BaseAdapterWithHeaderFooter<CastDto, CreditsAdapter.CreditsViewHolder> {

    public CreditsAdapter(Context context) {
        super(context);
    }

    @Override
    protected CreditsViewHolder createItemViewHolder(ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.item_credits, viewGroup, false);
        return new CreditsViewHolder(view);
    }

    @Override
    protected CreditsViewHolder createFooterViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    protected CreditsViewHolder createHeaderViewHolder(ViewGroup viewGroup) {
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

    static class CreditsViewHolder extends BaseViewHolder<CastDto> {

        @BindView(R.id.image_view_portret)
        ImageView imageViewPortret;

        @BindView(R.id.text_view_name)
        TextView textViewName;

        public CreditsViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(Context context) {
            textViewName.setText(getItem().getName());
            GlideApp.with(context)
                    .asBitmap()
                    .load(ApiUtils.getPathPoster(getItem().getProfilePath()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_error_outline_black_24dp)
                    .into(imageViewPortret);
        }
    }
}
