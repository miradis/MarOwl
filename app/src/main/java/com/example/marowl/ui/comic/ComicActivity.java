package com.example.marowl.ui.comic;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.marowl.R;
import com.google.android.material.button.MaterialButton;

public class ComicActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleComics;
    private TextView detailComics;
    private ImageView imageComics;
    MaterialButton randomComicButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("ComicTitle"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    setContentView(R.layout.activity_comics_page);
    imageComics=(ImageView) findViewById(R.id.comic_page_image);
    titleComics=(TextView) findViewById(R.id.comic_page_title);
    detailComics=(TextView) findViewById(R.id.comic_page_details);
    randomComicButton=(MaterialButton)findViewById(R.id.random_comic_button);
    Glide.with(this).load(getIntent().getStringExtra("ComicImage")).into(imageComics);
    titleComics.setText(getIntent().getStringExtra("ComicTitle"));
    detailComics.setText(getIntent().getStringExtra("ComicDetails"));
    randomComicButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.random_comic_button:
        }
    }
//    private void
}
