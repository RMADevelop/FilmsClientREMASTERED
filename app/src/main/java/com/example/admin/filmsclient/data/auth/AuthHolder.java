package com.example.admin.filmsclient.data.auth;

import com.example.admin.filmsclient.data.remote.AuthServer;
import com.example.admin.filmsclient.data.remote.dto.AuthCommonToken;
import com.example.admin.filmsclient.data.remote.dto.AuthSessionToken;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lombok.Getter;

import static com.example.admin.filmsclient.Const.API_KEY;

public class AuthHolder {

    private AuthServer authServer;

    @Getter
    private String commonToken;

    @Getter
    private String sessionToken = "1";

    @Inject
    public AuthHolder(AuthServer authServer) {
        this.authServer = authServer;
    }

    public Single<AuthCommonToken> refreshGuestToken() {
        return authServer.getCommonToken();
    }

    public void refreshSessionToken() {
        refreshGuestToken()
                .flatMap(authCommonToken -> authServer.createSession(API_KEY,
                        "RomanM",
                        "928451707spb",
                        authCommonToken.getRequestToken()))
                .subscribeOn(Schedulers.io())
                .doOnSuccess(new Consumer<AuthSessionToken>() {
                    @Override
                    public void accept(AuthSessionToken authSessionToken) throws Exception {
                        sessionToken = authSessionToken.getRequestToken();
                    }
                })
                .blockingGet();

    }
}
