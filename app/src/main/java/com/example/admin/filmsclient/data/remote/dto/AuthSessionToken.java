package com.example.admin.filmsclient.data.remote.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AuthSessionToken {

    @Getter
    @SerializedName("success")
    boolean isSuccess;

    @Getter
    @SerializedName("request_token")
    String requestToken;
}
