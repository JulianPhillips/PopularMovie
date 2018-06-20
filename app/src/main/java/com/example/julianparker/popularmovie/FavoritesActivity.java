package com.example.julianparker.popularmovie;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
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

import com.example.julianparker.popularmovie.Database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoritesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ArrayList<Movie> MoviesList = new ArrayList<>();
    private static final String BASE_URL ="https://api.themoviedb.org";
    private static final int PAGE = 1;
    private static  String API_KEY = " ";
    private static final String LANGUAGE = "en-US";
    private static  String CATEGORY = "popular";
    private static final String TAG = "MainActivity";
    private MoviesAdapter mAdapter;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.movie_gallery_rv) RecyclerView MovieScreenRv;
    @BindView(R.id.nav_view) NavigationView navigationView;
    private MovieViewModel mModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        API_KEY= getResources().getString(R.string.API_KEY);
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


        mModel = ViewModelProviders.of(this).get(MovieViewModel.class);


        // Create the observer which updates the UI.
        final Observer<Movie> nameObserver = new Observer<Movie>() {
            @Override
            public void onChanged(@Nullable final Movie newMovie) {
                // Update the UI, in this case, a adapter
                ArrayList<Movie> x = new ArrayList<>();


                    x.add(newMovie);


                mAdapter.setMovieList(x);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
       // mModel.getCurrentMovie().observe(this, nameObserver);





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
        else
        if(id == R.id.nav_favorite){
            Intent intent = new Intent(this,FavoritesActivity.class);
            startActivity(intent);
        }



        // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
