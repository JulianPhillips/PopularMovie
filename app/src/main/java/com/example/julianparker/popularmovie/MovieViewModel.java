package com.example.julianparker.popularmovie;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.julianparker.popularmovie.Database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {
    public static final String TAG = MovieViewModel.class.getSimpleName();
    private MutableLiveData<List<Movie>> movieDataList = new MutableLiveData<>();

    public LiveData<List<Movie>> getMovieDataList() {
        Log.i(TAG, "getMovieDataList: " + movieDataList.getValue());
        if (movieDataList.getValue() == null) {
            AsyncTask.execute(() -> {
                Log.i(TAG, "run: ");
                fetchMovieData();
            });
        }
        return movieDataList;
    }


    private void fetchMovieData() {


    }


}
