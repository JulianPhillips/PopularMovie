package com.example.julianparker.popularmovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface ApiInterface {
    @GET("/3/movie/{category}")
    Call<MovieResults> getMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page


    );
    @GET("/3/movie/{movie_id}")
    Call<TrailerResults> getTrailers(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("append_to_response") String appendToResponse
            );
    @GET("/3/movie/{movie_id}/reviews")
    Call<ReviewResults> getReviews(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}