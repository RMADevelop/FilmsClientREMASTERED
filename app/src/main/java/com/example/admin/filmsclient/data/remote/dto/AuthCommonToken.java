package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;

@Builder
public class AuthCommonToken {

    @SerializedName("success")
    boolean isSuccess;

    @SerializedName("request_token")
    String requestToken;
}
