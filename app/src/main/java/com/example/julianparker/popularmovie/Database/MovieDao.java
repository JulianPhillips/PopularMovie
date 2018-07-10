package com.example.julianparker.popularmovie.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.julianparker.popularmovie.Movie;

import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM Movie WHERE id = :id")
   LiveData< Movie> getMovie(int id);

    @Insert(onConflict = REPLACE)
    void insert(Movie movie);

    @Delete
    void delete(Movie movie);

    @Query("SELECT * FROM Movie ORDER BY id")
    LiveData<List<Movie>> getAll();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Movie favMovie);


}
