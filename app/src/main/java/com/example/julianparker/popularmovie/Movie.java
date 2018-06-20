package com.example.julianparker.popularmovie;



import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import org.parceler.Parcel;

@Entity(primaryKeys = "Id", tableName = "Movie")
@Parcel
public class Movie  {
     @ColumnInfo(name = "title")
     String title;
     @ColumnInfo(name = "poster")
     String poster;
     @ColumnInfo(name="description")
     String description;
     @ColumnInfo(name = "voteAverage")
     Double voteAverage;
     @ColumnInfo(name = "releaseDate")
     String releaseDate;
     int Id;

     public Movie(){

     }
    public Movie(String Title, String Poster, String Description, Double VoteAverage, String ReleaseDate, int ID){
        title = Title;
        poster = Poster;
        description = Description;
        releaseDate = ReleaseDate;
        voteAverage = VoteAverage;
        Id = ID;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
    return poster;
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
    public void setId(int x){
         Id = x;
    }
    public int getId(){
         return Id;
    }

}