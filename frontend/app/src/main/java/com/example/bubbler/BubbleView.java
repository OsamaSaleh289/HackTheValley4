package com.example.bubbler;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BubbleView extends AppCompatActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.bubble);

    BubbleModel model = new BubbleModel(this);


  }

}
