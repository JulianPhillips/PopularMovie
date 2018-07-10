package com.example.julianparker.popularmovie;

<<<<<<< HEAD
=======
import android.arch.persistence.room.Room;
>>>>>>> parent of 40ad742... LiveData Still not implemented
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {


    private static final String BASE_URL = "https://api.themoviedb.org";
    private static final String LANGUAGE = "en-US";
    private static final String TAG = "DetailsActivity";
    private static final String APPEND_TO_RESPONSE = "videos";
    private static final String YOUTUBE_BASE_URL = "https://www.youtube.com/watch?v=";
    private static final String REVIEWS ="reviews";
    private static final int PAGE = 1;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private boolean AlreadyAFavorite = false;
   // private DatabaseHelper databaseHelper;

    @BindView(R.id.Favorite)
    Button Favorite;
=======
>>>>>>> parent of 655b213... Update
=======
>>>>>>> parent of 655b213... Update
=======
>>>>>>> parent of 655b213... Update

    @BindView(R.id.Reviews)
    TextView Reviews;
    @BindView(R.id.VideoButton)
    Button Video;
    @BindView(R.id.Description)
    TextView Description;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.PosterImage)
    ImageView Image;
    @BindView(R.id.ReleaseDate)
    TextView ReleaseDate;
    @BindView(R.id.VoterAvg)
    TextView VoterAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

<<<<<<< HEAD
=======

>>>>>>> parent of 40ad742... LiveData Still not implemented
        final Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("MOVIE"));

        int CATEGORY = movie.getId();
        String API_KEY = getResources().getString(R.string.API_KEY);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface myInterface = retrofit.create(ApiInterface.class);

        Call<TrailerResults> TrailerCall = myInterface.getTrailers(CATEGORY, API_KEY, LANGUAGE, APPEND_TO_RESPONSE);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Log.d(TAG,"About to call AppDatabase");

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().build();

        Log.d(TAG,"AppDatabase was built");


<<<<<<< HEAD


        for(int i =0; i< db.movieDao().getAll().; i++){
=======
        for(int i =0; i<db.movieDao().getAll().size(); i++){
>>>>>>> parent of 40ad742... LiveData Still not implemented
            if(db.movieDao().getAll().get(i).Id == movie.Id ){
                AlreadyAFavorite = true;
                Favorite.setBackground(getDrawable(R.drawable.ic_favorite));
            }
        }


        Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AlreadyAFavorite == true){

                    AlreadyAFavorite = false;
                    Favorite.setBackground(getDrawable(R.drawable.ic_favorite_not));
                    Log.d(TAG,"The icon has been changed");
                    db.movieDao().delete(movie);
                    Log.d(TAG,"The movie has been deleted:"+db.movieDao().getAll().get(0).title);

                    db.close();

                }
                else
                {

                    AlreadyAFavorite = true;

<<<<<<< HEAD
                    new Thread(new Runnable() {
                        public void run() {
                            // a potentially  time consuming task
                            if (AlreadyAFavorite == true){

                                AlreadyAFavorite = false;
                                Favorite.setBackground(getDrawable(R.drawable.ic_favorite_not));


                            }
                            else
                            {
                                AlreadyAFavorite = true;
                                db.movieDao().insert(movie);
                                Log.d(TAG,"The movie has been added");
                                Favorite.setBackground(getDrawable(R.drawable.ic_favorite));
                                Log.d(TAG,"The icon has been changed");
                                db.close();
                            }
                                }
                            }).start();
                        }
                    });
=======
>>>>>>> parent of 655b213... Update
=======
>>>>>>> parent of 655b213... Update
=======
>>>>>>> parent of 655b213... Update
=======
                    db.movieDao().insert(movie);
                    Log.d(TAG,"The movie has been added");
                    Favorite.setBackground(getDrawable(R.drawable.ic_favorite));
                    Log.d(TAG,"The icon has been changed");
                    db.close();
                }

            }
        });
>>>>>>> parent of 40ad742... LiveData Still not implemented

        TrailerCall.enqueue(new Callback<TrailerResults>() {
                         @Override
                         public void onResponse(Call<TrailerResults> call, Response<TrailerResults> response) {
                             TrailerResults results = response.body();
                             String videoPath;


                             videoPath = YOUTUBE_BASE_URL + results.getVideos().getResults().get(0).getKey();


                             Uri videoUri = Uri.parse(videoPath);

                             Log.d(TAG, videoPath);


                             setUpActivity(movie, videoUri);
                         }

                         @Override
                         public void onFailure(Call<TrailerResults> call, Throwable t) {
                             t.printStackTrace();

                         }

                     }
        );

        Call<ReviewResults>  ReviewCall = myInterface.getReviews(CATEGORY, API_KEY, LANGUAGE, PAGE);

        ReviewCall.enqueue(new Callback<ReviewResults>() {
            @Override
            public void onResponse(Call<ReviewResults> call, Response<ReviewResults> response) {
                ReviewResults results = response.body();
                String ReviewText = "";
                List<ReviewResults.ResultsBean> reviewList = results.getResults();

                for (int i =0; i< results.getResults().size(); i++){

                    ReviewText = ReviewText+"\n";
                    ReviewText = ReviewText+ "\nAuthor: "+reviewList.get(i).getAuthor();
                    ReviewText = ReviewText+ "\nPost: "+reviewList.get(i).getContent();

                }

                    if (ReviewText.isEmpty()){
                    Reviews.setText("No Reviews Right Now");
                    }
                    else
                    Reviews.setText("Reviews \n\n"+ReviewText);
            }

            @Override
            public void onFailure(Call<ReviewResults> call, Throwable t) {

            }
        });


    }

    private void setUpActivity(Movie movie, final Uri video) {
        Description.setText("Plot: " + movie.getDescription());
        Title.setText("Title: " + movie.getTitle());
        VoterAvg.setText("Voter Average: " + movie.getVoteAverage().toString());
        ReleaseDate.setText("Release Date: " + movie.getReleaseDate());
        Picasso.get().load("http://image.tmdb.org/t/p/w185"+movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(Image);
        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(video);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}