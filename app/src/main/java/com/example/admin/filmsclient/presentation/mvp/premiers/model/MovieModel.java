package com.example.admin.filmsclient.presentation.mvp.premiers.model;

import com.example.admin.filmsclient.domain.core.pojo.Dates;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieModel {

    boolean hasNext;

    List<ResultModel> results;

    int page;

    int totalResults;

    Dates dates;

    int totalPages;
}
