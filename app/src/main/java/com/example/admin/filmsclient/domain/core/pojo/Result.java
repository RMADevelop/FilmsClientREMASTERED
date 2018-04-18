package com.example.admin.filmsclient.domain.core.pojo;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Result {

    private int voteCount;

    private int id;

    private boolean video;

    private double voteAverage;

    private String title;

    private float popularity;

    private String posterPath;

    private String originalLanguage;

    private String originalTitle;

    private List<Integer> genreIds;

    private String backdropPath;

    private boolean adult;

    private String overview;

    private String releaseDate;
}
