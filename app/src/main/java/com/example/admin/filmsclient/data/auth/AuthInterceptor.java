package com.example.admin.filmsclient.data.auth;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";

    private AuthHolder authHolder;

    public AuthInterceptor(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if (chain.request().header(ACCESS_TOKEN_HEADER) == null) {
            builder.addHeader(ACCESS_TOKEN_HEADER, authHolder.getAuthToken());
        }

        return chain.proceed(builder.build());
    }
}
