package com.example.admin.filmsclient.presentation.ui.core.adapters;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import lombok.Getter;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    @Getter
    T item;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    protected abstract void bind(Context context);

    @CallSuper
    public void bind(Context context, T item, int position) {
        this.item = item;
        bind(context);
    }
}
