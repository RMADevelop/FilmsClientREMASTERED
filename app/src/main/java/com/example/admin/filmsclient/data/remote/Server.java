package com.example.admin.filmsclient.data.remote;

import com.example.admin.filmsclient.data.remote.dto.FilmDetailDto;
import com.example.admin.filmsclient.data.remote.dto.MovieDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Server {

    @GET("movie/now_playing?api_key=0a94b53a493baafc9c1434714336e957&language=en-US")
    Single<MovieDto> getMovie(@Query("page") String page);

    @GET("movie/{movie_id}?api_key=0a94b53a493baafc9c1434714336e957&language=en-US")
    Single<FilmDetailDto> getFilmInfo(@Path("movie_id") int id);
}
