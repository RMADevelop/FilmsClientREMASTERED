package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreditsDto {

    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<CastDto> castList;
}
