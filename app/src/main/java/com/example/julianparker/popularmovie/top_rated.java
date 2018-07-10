package com.example.julianparker.popularmovie;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class top_rated extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ArrayList<Movie> MoviesList = new ArrayList<>();
    private static final String BASE_URL ="https://api.themoviedb.org";
    private static final int PAGE = 1;
    private static final String API_KEY = "6fe60bcb808a908fa0c56969a548ff34";
    private static final String LANGUAGE = "en-US";
    private static  String CATEGORY = "top_rated";
    private static final String TAG = "top_rated";
    private MoviesAdapter mAdapter;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.movie_gallery_rv)
    RecyclerView MovieScreenRv;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // MovieScreenRv = (RecyclerView) findViewById(R.id.movie_gallery_rv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface myInterface = retrofit.create(ApiInterface.class);
        Call<MovieResults> call =  myInterface.getMovies(CATEGORY,API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();
                ArrayList<Movie> newMovies = new ArrayList<>();
                for(int i =0; i<listOfMovies.size(); i++){

                    Movie newMovie = new  Movie(
                            listOfMovies.get(i).getTitle(),
                            listOfMovies.get(i).getPoster_path(),
                            listOfMovies.get(i).getOverview(),
                            listOfMovies.get(i).getVote_average(),
                            listOfMovies.get(i).getRelease_date(),
                            listOfMovies.get(i).getId());
                    Log.d(TAG,"added " + listOfMovies.get(i).getPoster_path());
                    newMovies.add(newMovie);

                }

                mAdapter.setMovieList(newMovies);

            }
            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });



        GridLayoutManager layoutManager = new GridLayoutManager(this,getSpan());
        MovieScreenRv.setLayoutManager(layoutManager);
        MovieScreenRv.setHasFixedSize(true);
        mAdapter = new MoviesAdapter(this,MoviesList);
        MovieScreenRv.setAdapter(mAdapter);
    }

    private int getSpan() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return 4;
        }
        return 2;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_top_rated) {
            Intent intent = new  Intent(this, top_rated.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_popular) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
