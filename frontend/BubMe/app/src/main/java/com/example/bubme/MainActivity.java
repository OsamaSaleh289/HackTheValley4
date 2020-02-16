package com.example.bubme;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView circle1;
    ImageView circle2;
    ImageView circle3;
    ArrayList<ImageView> circles;
    char leftOrRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle1 = findViewById(R.id.imageView4);
        circle2 = findViewById(R.id.imageView7);
        circle3 = findViewById(R.id.imageView8);
        leftOrRight = 'L';

        circles = new ArrayList<ImageView>();
        circles.add(circle1);
        circles.add(circle2);
        circles.add(circle3);


        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                //your method
                if (leftOrRight == 'L') {
                    for (ImageView circle : circles) {
                        circle.setTranslationX(-1);
                        circle.setTranslationY(2);
                        leftOrRight = 'R';


                    }
                } else{
                    for (ImageView circle : circles) {
                        circle.setTranslationX(1);
                        circle.setTranslationY(2);
                        leftOrRight = 'L';

                    }
                }





            }
        }, 0, 100);//put here time 1000 milliseconds=1 second


        //parentView.addView(TextView);


    }
}
