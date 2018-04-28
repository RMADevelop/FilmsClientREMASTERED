package com.example.admin.filmsclient.domain.core.pojo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FilmDetail {

    private boolean adult;

    private String backdropPath;

    private int budget;

    private int id;

    private String imdbId;

    private String originalLanguage;

    private String originalTitle;

    private String overview;

    private float popularity;

    private String posterPath;

    private String releaseDate;

    private int revenue;

    private int runtime;

    private String status;

    private String tagline;

    private String title;

    private boolean video;

    private float voteAverage;

    private int voteCount;
}
