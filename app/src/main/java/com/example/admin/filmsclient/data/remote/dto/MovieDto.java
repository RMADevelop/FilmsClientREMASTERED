package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MovieDto {
    @SerializedName("results")
    List<ResultDto> results = null;
    @SerializedName("page")
    int page;
    @SerializedName("total_results")
    int totalResults;
    @SerializedName("dates")
    DatesDto dates;
    @SerializedName("total_pages")
    int totalPages;
}
