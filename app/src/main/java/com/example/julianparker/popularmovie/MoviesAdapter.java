package com.example.julianparker.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>
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


        // This is how we use Picasso to load images from the internet.
        Picasso.get().load(mMovieList.get(position).getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return  mMovieList.size();
    }

    public void setMovieList(ArrayList<Movie> moviesList)
    {
        this.mMovieList.clear();
        this.mMovieList.addAll(moviesList);
        notifyDataSetChanged();
    }



    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ImageView imageView;

        public MovieViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView =  itemView.findViewById(R.id.RowsOfMoviesImage);
        }


        @Override
        public void onClick(View v) {
            Movie newMovie = mMovieList.get(getAdapterPosition());
            Intent intent  = new Intent(mContext, DetailsActivity.class);

            intent.putExtra("MOVIE", Parcels.wrap(newMovie));
            mContext.startActivity(intent);
        }
    }
}

