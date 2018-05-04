package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewsDto {
    @SerializedName("id")
    private int idFilm;

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("results")
    private List<ReviewDto> listReview;
}
