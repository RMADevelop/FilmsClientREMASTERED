package com.example.admin.filmsclient.data.repositories.auth;

import android.content.SharedPreferences;

import com.example.admin.filmsclient.domain.auth.AuthRepository;

import javax.inject.Inject;

import static com.example.admin.filmsclient.Const.SPREF_LOGIN;
import static com.example.admin.filmsclient.Const.SPREF_PASS;

public class AuthDataRepository implements AuthRepository {


    private final SharedPreferences sharedPreferences;

    @Inject
    public AuthDataRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void saveAuthData(String login, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SPREF_LOGIN, login);
        editor.putString(SPREF_PASS, password);
        editor.apply();
    }
}
