package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewDto {

    @SerializedName("author")
    private String author;

    @SerializedName("content")
    private String content;

    @SerializedName("id")
    private String idReview;


}
