package com.example.marowl.ui.comic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marowl.R;

public class AddComicActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comics);

        ImageView imageComic=findViewById(R.id.comic_image_view);
        EditText titleComic=findViewById(R.id.insert_title_editText);
        EditText detailComic=findViewById(R.id.insert_details_editText);
        Button chooseImage=findViewById(R.id.choose_image);
        Button uploadImage=findViewById(R.id.upload_image);

        chooseImage.setOnClickListener(this);
        uploadImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.choose_image:
                break;

            case R.id.upload_image:
                break;
        }
    }

//    public void getImage(){
//        Intent intentChooser=new Intent();
//        intentChooser.setType("image/");
//        intentChooser.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult();
//    }
}
