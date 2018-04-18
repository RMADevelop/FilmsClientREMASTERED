package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DatesDto {

    @SerializedName("maximum")
    private String maximum;
    @SerializedName("minimum")
    private String minimum;

}
