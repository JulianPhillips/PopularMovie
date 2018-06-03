package com.example.julianparker.popularmovie;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie  {
    private String title;
    private String poster;
    private String description;
    private String backdrop;

    public Movie(String Title, String Poster, String Description, String Backdrop){
        title = Title;
        poster = Poster;
        description = Description;
        backdrop = Backdrop;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return "http://i.imgur.com/DvpvklR.png";
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

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

}