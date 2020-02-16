package com.example.bubbler;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Date currentTime;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    currentTime = Calendar.getInstance().getTime();
  }

  public void check(View view){
      Intent intent = new Intent(this, BubbleView.class);
      intent.putExtra("Time", currentTime);
      EditText text = findViewById(R.id.thought);
      String content = text.getText().toString();
      intent.putExtra("Content", content);
      startActivity(intent);
  }
}
