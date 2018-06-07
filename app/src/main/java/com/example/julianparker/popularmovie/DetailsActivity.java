package com.example.julianparker.popularmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

        if(getIntent().hasExtra("POSTERURL") &&
                getIntent().hasExtra("TITLE")&&
                getIntent().hasExtra("DESCRIPTION")&&
                getIntent().hasExtra("VOTERAVG")&&
                getIntent().hasExtra("RELEASEDATE")){

            String releaseDate = getIntent().getStringExtra("RELEASEDATE");
            Double voterAvg = getIntent().getDoubleExtra("VOTERAVG",0.0);
            String posterUrl = getIntent().getStringExtra("POSTERURL");
            String title = getIntent().getStringExtra("TITLE");
            String description = getIntent().getStringExtra("DESCRIPTION");
            setUpActivity(posterUrl,title,description, releaseDate, voterAvg);
        }



    }

    private void setUpActivity(String posterUrl, String title, String description, String releasedate, Double voteravg) {
        Description.setText("Plot: "+description);
        Title.setText("Title: "+title);
        VoterAvg.setText("Voter Average: "+voteravg.toString());
        ReleaseDate.setText("Release Date: "+releasedate);
        Picasso.get().load(posterUrl)
                .placeholder(R.color.colorAccent)
                .into(Image);
    }

}
