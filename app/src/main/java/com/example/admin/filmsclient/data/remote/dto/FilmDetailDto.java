package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FilmDetailDto {

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("backdrop_path")
    private String backdropPath;

//    @SerializedName("belongs_to_collection")
//    private BelongsToCollection belongsToCollection;
    @SerializedName("budget")
    private int budget;

//    @SerializedName("genres")
//    private List<Genre> genres = null;

    @SerializedName("homepage")
    private String homepage;

    @SerializedName("id")
    private int id;

    @SerializedName("imdb_id")
    private String imdbId;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("poster_path")
    private String posterPath;

//    @SerializedName("production_companies")
//    private List<ProductionCompany> productionCompanies = null;

//    @SerializedName("production_countries")
//    private List<ProductionCountry> productionCountries = null;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("runtime")
    private int runtime;

//    @SerializedName("spoken_languages")
//    private List<SpokenLanguage> spokenLanguages = null;

    @SerializedName("status")
    private String status;

    @SerializedName("tagline")
    private String tagline;

    @SerializedName("title")
    private String title;

    @SerializedName("video")
    private boolean video;

    @SerializedName("vote_average")
    private float voteAverage;

    @SerializedName("vote_count")
    private int voteCount;
}
