package com.submission.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.submission.moviecatalogue.adapter.CardMovieAdapter;
import com.submission.moviecatalogue.model.Movie;
import com.submission.moviecatalogue.model.MovieData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        list.addAll(MovieData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        CardMovieAdapter cardMovieAdapter = new CardMovieAdapter(list);
        rvMovies.setAdapter(cardMovieAdapter);

    }


}
