package com.example.admin.filmsclient.data.remote;

import com.example.admin.filmsclient.data.remote.dto.AuthCommonToken;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface AuthServer {

    @GET("authentication/token/new?api_key=0a94b53a493baafc9c1434714336e957")
    Single<AuthCommonToken> getCommonToken();
}
