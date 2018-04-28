package com.example.admin.filmsclient.presentation.mvp.filmDetail.models;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FilmDetailModel implements Parcelable {

    private boolean adult;
    private String backdropPath;
    private int budget;
    private int id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private float popularity;
    private String posterPath;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private float voteAverage;
    private int voteCount;

    public FilmDetailModel(boolean adult, String backdropPath, int budget, int id, String imdbId, String originalLanguage, String originalTitle, String overview, float popularity, String posterPath, String releaseDate, int revenue, int runtime, String status, String tagline, String title, boolean video, float voteAverage, int voteCount) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.budget = budget;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    protected FilmDetailModel(Parcel in) {
        adult = in.readByte() != 0;
        backdropPath = in.readString();
        budget = in.readInt();
        id = in.readInt();
        imdbId = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        overview = in.readString();
        popularity = in.readFloat();
        posterPath = in.readString();
        releaseDate = in.readString();
        revenue = in.readInt();
        runtime = in.readInt();
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
        video = in.readByte() != 0;
        voteAverage = in.readFloat();
        voteCount = in.readInt();
    }

    public static final Creator<FilmDetailModel> CREATOR = new Creator<FilmDetailModel>() {
        @Override
        public FilmDetailModel createFromParcel(Parcel in) {
            return new FilmDetailModel(in);
        }

        @Override
        public FilmDetailModel[] newArray(int size) {
            return new FilmDetailModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(backdropPath);
        dest.writeInt(budget);
        dest.writeInt(id);
        dest.writeString(imdbId);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(overview);
        dest.writeFloat(popularity);
        dest.writeString(posterPath);
        dest.writeString(releaseDate);
        dest.writeInt(revenue);
        dest.writeInt(runtime);
        dest.writeString(status);
        dest.writeString(tagline);
        dest.writeString(title);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeFloat(voteAverage);
        dest.writeInt(voteCount);
    }
}
