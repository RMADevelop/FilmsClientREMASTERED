package com.example.admin.filmsclient.presentation.ui.core.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class BaseAdapterWithHeaderFooter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {

    private final static int VIEW_TYPE_ITEM = 0;
    private final static int VIEW_TYPE_HEADER = 1;
    private final static int VIEW_TYPE_FOOTER = 2;
    protected LayoutInflater inflater;
    protected List<T> list = new ArrayList<>();
    private Context context;

    public BaseAdapterWithHeaderFooter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_FOOTER:
                return createFooterViewHolder(parent);
            case VIEW_TYPE_HEADER:
                return createHeaderViewHolder(parent);
            default:
                return createItemViewHolder(parent, viewType);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getHeadersCount()) {
            return VIEW_TYPE_HEADER;
        }
        if (position < list.size() + getHeadersCount()) {
            return VIEW_TYPE_ITEM;
        }
        return VIEW_TYPE_FOOTER;
    }

    protected abstract VH createItemViewHolder(ViewGroup viewGroup, int viewType);

    protected abstract VH createFooterViewHolder(ViewGroup viewGroup);

    protected abstract VH createHeaderViewHolder(ViewGroup viewGroup);

    protected abstract int getHeadersCount();

    protected abstract int getFootersCount();

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        T item = isItemPosition(position) ? list.get(position - getHeadersCount()) : null;
        holder.bind(context, item, position);
    }

    private boolean isItemPosition(int position) {
        return getHeadersCount() <= position && position < getHeadersCount() + list.size();
    }

    @Override
    public int getItemCount() {
        return list.size() + getHeadersCount() + getFootersCount();
    }

    public void setItems(List<T> list) {
        this.list = list != null ? list : Collections.emptyList();
        notifyDataSetChanged();
    }

    public void addItems(List<T> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

}
