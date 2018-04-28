package com.example.admin.filmsclient.data.auth;

import com.example.admin.filmsclient.data.remote.AuthServer;
import com.example.admin.filmsclient.data.remote.dto.AuthCommonToken;

import io.reactivex.Single;
import lombok.Getter;

public class AuthHolder {

    private AuthServer authServer;

    @Getter
    private String commonToken;

    @Getter
    private String authToken;

    public AuthHolder(AuthServer authServer) {
        this.authServer = authServer;
    }

    public Single<AuthCommonToken> refreshToken() {
        return authServer.getCommonToken();

    }
}
