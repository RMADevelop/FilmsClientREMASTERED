package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.auth.AuthHolder;
import com.example.admin.filmsclient.data.auth.AuthInterceptor;
import com.example.admin.filmsclient.data.auth.MainAuthenticator;
import com.example.admin.filmsclient.data.remote.AuthServer;
import com.example.admin.filmsclient.data.remote.Server;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AuthNetworkModule {

    @Provides
    @Singleton
    Interceptor provideAuthInterceptor(AuthHolder authHolder) {
        return new AuthInterceptor(authHolder);
    }

    @Provides
    @Singleton
    Authenticator provideMainAuthenticator(AuthHolder authHolder) {
        return new MainAuthenticator(authHolder);
    }


    @Provides
    @Singleton
    @Named("auth")
    public OkHttpClient provideOkHttp(Interceptor interceptor, Authenticator authenticator) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .authenticator(authenticator)
                .build();
    }

    @Provides
    @Singleton
    @Named("auth")
    public Retrofit provideRetrofit(@Named("auth") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("auth")
    public Server provideServer(@Named("auth") Retrofit retrofit) {
        return retrofit.create(Server.class);
    }

    @Provides
    @Singleton
    @Named("auth")
    public AuthServer provideAuthServer(@Named("auth") Retrofit retrofit) {
        return retrofit.create(AuthServer.class);
    }
}
