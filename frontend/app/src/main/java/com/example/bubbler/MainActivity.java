package com.example.bubbler;

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

    Button enter = findViewById(R.id.enter);
    enter.setOnClickListener(new MenuController(this, this));
  }
}
