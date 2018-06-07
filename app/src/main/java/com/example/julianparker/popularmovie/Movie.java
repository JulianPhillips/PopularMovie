package com.example.julianparker.popularmovie;

import org.parceler.Parcel;

@Parcel
public class Movie  {
     String title;
     String poster;
     String description;
     Double voteAverage;
     String releaseDate;
     public Movie(){

     }
    public Movie(String Title, String Poster, String Description, Double VoteAverage, String ReleaseDate){
        title = Title;
        poster = Poster;
        description = Description;
        releaseDate = ReleaseDate;
        voteAverage = VoteAverage;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
    return "http://image.tmdb.org/t/p/w185"+poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(java.lang.String x) {
        releaseDate = x;
    }
}