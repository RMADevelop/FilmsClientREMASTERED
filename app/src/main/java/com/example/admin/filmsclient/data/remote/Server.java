package com.example.admin.filmsclient.data.remote;

import com.example.admin.filmsclient.data.remote.dto.MovieDto;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Server {


    @GET("movie/now_playing?api_key=0a94b53a493baafc9c1434714336e957&language=en-US&page=1")
    Single<MovieDto> getMovie();
}
