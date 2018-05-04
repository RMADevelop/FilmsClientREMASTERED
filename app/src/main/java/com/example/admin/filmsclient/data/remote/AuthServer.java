package com.example.admin.filmsclient.data.remote;

import com.example.admin.filmsclient.data.remote.dto.AuthCommonToken;
import com.example.admin.filmsclient.data.remote.dto.AuthSessionToken;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AuthServer {

    @GET("authentication/token/new?api_key=0a94b53a493baafc9c1434714336e957")
    Single<AuthCommonToken> getCommonToken();

    @GET("authentication/token/validate_with_login")
    Single<AuthSessionToken> createSession(
            @Query("api_key") String apiKey,
            @Query("username") String login,
            @Query("password") String password,
            @Query("request_token") String token);
}
