package com.example.admin.filmsclient.domain.core.pojo;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Movie {

    List<Result> results;

    int page;

    int totalResults;

    Dates dates;

    int totalPages;
}
