package com.ahmedkhozam8085.thetask.view.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.ahmedkhozam8085.thetask.R;
import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.fullScreenImage);
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        Glide.with(getApplicationContext()).load(image).into(imageView);
    }
}