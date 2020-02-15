package com.example.bubbler;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Date currentTime = Calendar.getInstance().getTime();
    System.out.println(currentTime);
  }

  public void bubblePage(View view){
    Intent intent = new Intent(this, BubbleView.class);
    startActivity(intent);
  }
}
