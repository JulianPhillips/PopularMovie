package com.example.julianparker.popularmovie;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

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



            Movie movie = Parcels.unwrap(getIntent().getParcelableExtra("MOVIE"));
            setUpActivity(movie);


    }





    private void setUpActivity(Movie movie) {
        Description.setText("Plot: "+movie.getDescription());
        Title.setText("Title: "+movie.getTitle());
        VoterAvg.setText("Voter Average: "+movie.getVoteAverage().toString());
        ReleaseDate.setText("Release Date: "+movie.getReleaseDate());
        Picasso.get().load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(Image);
    }

}
