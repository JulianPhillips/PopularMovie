package com.example.julianparker.popularmovie;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder>
    {
        private List<Movie> mMovieList;
        private LayoutInflater mInflater;
        private Context mContext;

        public MoviesAdapter(Context context, ArrayList<Movie> MovieArrayList)
        {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
            this.mMovieList = MovieArrayList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = mInflater.inflate(R.layout.rows_of_movie, parent, false);
            MovieViewHolder viewHolder = new MovieViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position)

        {
            Movie movie = mMovieList.get(position);

            // This is how we use Picasso to load images from the internet.
            Picasso.get().load(movie.getPoster())
                    .placeholder(R.color.colorAccent)
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount()
        {
            return (mMovieList == null) ? 0 : mMovieList.size();
        }

        public void setMovieList(ArrayList<Movie> moviesList)
        {
            this.mMovieList.clear();
            this.mMovieList.addAll(moviesList);
            // The adapter needs to know that the data has changed. If we don't call this, app will crash.
            notifyDataSetChanged();
        }
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
    public ImageView imageView;

        public MovieViewHolder(View itemView)
        {
            super(itemView);
            imageView =  itemView.findViewById(R.id.imageView);
        }
    }

     @BindView(R.id.toolbar) Toolbar toolbar;
    private ArrayList<Movie> MoviesList = new ArrayList<>();
    private static final String BASE_URL ="https://api.themoviedb.org";
    private static final int PAGE = 1;
    private static final String API_KEY = "6fe60bcb808a908fa0c56969a548ff34";
    private static final String LANGUAGE = "en-US";
    private static  String CATEGORY = "popular";
    private static final String TAG = "MainActivity";
    private MoviesAdapter mAdapter;
     @BindView(R.id.drawer_layout) DrawerLayout drawer;
     @BindView(R.id.movie_gallery_rv) RecyclerView MovieScreenRv;
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
               for(int i =0; i<listOfMovies.size(); i++){

                   Movie newMovie = new Movie(listOfMovies.get(i).getTitle(), listOfMovies.get(i).getPoster_path(), listOfMovies.get(i).getOverview(), listOfMovies.get(i).getBackdrop_path());
                    MoviesList.add(newMovie);
               }

            }
            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
            t.printStackTrace();
            }
        });



        GridLayoutManager layoutManager = new GridLayoutManager(this, getSpan());
        MovieScreenRv.setLayoutManager(layoutManager);
        MovieScreenRv.setHasFixedSize(true);
        mAdapter = new MoviesAdapter(this,MoviesList);
        mAdapter.setMovieList(MoviesList);
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
       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            // Handle the camera action
        } else if (id == R.id.nav_popular) {

        }



       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
