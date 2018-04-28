package com.example.admin.filmsclient.di.modules;

import com.example.admin.filmsclient.data.remote.AuthServer;
import com.example.admin.filmsclient.data.remote.Server;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private static final long TIMEOUT_IN_SECONDS = 20;

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    @Named("common")
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = getLoggingInterceptor();
        builder.addInterceptor(interceptor);

        builder.readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    @Named("common")
    public Retrofit provideRetrofit(@Named("common") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("common")
    public Server provideServer(@Named("common") Retrofit retrofit) {
        return retrofit.create(Server.class);
    }

    @Provides
    @Singleton
    @Named("common")
    public AuthServer provideAuthServer(@Named("common") Retrofit retrofit) {
        return retrofit.create(AuthServer.class);
    }
}
