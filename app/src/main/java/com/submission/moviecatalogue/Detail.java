package com.submission.moviecatalogue;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.submission.moviecatalogue.model.Movie;

public class Detail extends AppCompatActivity {

    String name, date, category, description, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        if(movie != null) {
            name = movie.getName();
            date = movie.getDate();
            category = movie.getCategory();
            description = movie.getDescription();
            photo = movie.getPhoto();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(name);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setTextDetail();
    }

    public void setTextDetail(){
        TextView tvname = findViewById(R.id.item_name);
        TextView tvdate = findViewById(R.id.item_date);
        TextView tvdescription = findViewById(R.id.item_description);
        TextView tvphotoqty = findViewById(R.id.item_photo_qty);
        ImageView imgphoto = findViewById(R.id.item_photo);

        tvname.setText(name);
        tvdate.setText(date);
        tvphotoqty.setText(category);
        tvdescription.setText(description);

        Glide.with(this)
                .load(photo)
                .into(imgphoto);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }


    public static final String EXTRA_MOVIE = "extra_movie";
}
