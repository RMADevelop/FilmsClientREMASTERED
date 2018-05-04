package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CastDto {
    @SerializedName("cast_id")
    private int idCast;

    @SerializedName("character")
    private String character;

    @SerializedName("credit_id")
    private String creditId;

    @SerializedName("gender")
    private int genderId;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private int irder;

    @SerializedName("profile_path")
    private String profilePath;
}