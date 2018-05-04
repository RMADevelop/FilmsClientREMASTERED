package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.remote.AuthServer;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class CommonNetworkModule {

    @Provides
    @Singleton
    @Named("common")
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    @Named("common")
    Retrofit provideRetrofit(@Named("common") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    AuthServer providerServer(@Named("common") Retrofit retrofit) {
        return retrofit.create(AuthServer.class);
    }


}
