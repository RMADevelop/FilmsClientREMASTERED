package com.example.admin.filmsclient.domain;

import javax.inject.Inject;

public class PaginationState {

    private int page = 1;

    private int totalPage = 0;

    @Inject
    public PaginationState() {
    }

    public void nextPage() {
        page++;
    }

    public int getPage() {
        return page;
    }
}
