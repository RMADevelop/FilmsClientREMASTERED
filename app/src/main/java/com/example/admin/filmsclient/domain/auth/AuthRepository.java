package com.example.admin.filmsclient.domain.auth;

public interface AuthRepository {
    void saveAuthData(String login, String password);
}
