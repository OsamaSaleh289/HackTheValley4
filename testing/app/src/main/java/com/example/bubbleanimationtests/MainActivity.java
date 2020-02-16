package com.example.bubbleanimationtests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //// Animate Trump
        //ImageView trumpIMG = findViewById(R.id.trump);
        //Animation animated_trump = AnimationUtils.loadAnimation(this, R.anim.animated_trump);
        //trumpIMG.startAnimation(animated_trump);

        ImageView animImg = findViewById(R.id.anime_gurl);
        Animation animApp = AnimationUtils.loadAnimation(this, R.anim.animated_bounce);

        animImg.startAnimation(animApp);
    }
}
