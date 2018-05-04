package com.example.admin.filmsclient.data.auth;

import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public class MainAuthenticator implements Authenticator {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";

    private AuthHolder authHolder;

    public MainAuthenticator(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    @Nullable
    @Override
    public synchronized Request authenticate(Route route, Response response) throws IOException {

        String storedToken = authHolder.getSessionToken();
        String requestToken = response.header(ACCESS_TOKEN_HEADER);
        Request.Builder builder = response.request().newBuilder();
        if (storedToken.equals(requestToken)) {
            authHolder.refreshSessionToken();
        }

        return builder.header(ACCESS_TOKEN_HEADER, authHolder.getSessionToken()).build();
    }
}
