package com.example.bubbler;

import android.animation.ValueAnimator;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class BubbleView extends AppCompatActivity{

  private FusedLocationProviderClient fusedLocationClient;
  private Location location;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bubble_page);

    BubbleModel model = new BubbleModel(this);

      final TextView first = (TextView) findViewById(R.id.first);
      final TextView second = (TextView) findViewById(R.id.second);

      ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
      animator.setRepeatCount(ValueAnimator.INFINITE);
      animator.setInterpolator(new LinearInterpolator());
      animator.setDuration(9000L);
      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
              float progress = (float) animation.getAnimatedValue();
              float width = first.getWidth();
              float translationX = width * progress;
              first.setTranslationX(translationX);
              second.setTranslationX(translationX - width);
          }
      });
      animator.start();

    fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    fusedLocationClient.getLastLocation()
        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
          @Override
          public void onSuccess(Location location) {
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
              // Logic to handle location object
              first.setText(
                  "Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            }
          }
        });

    fusedLocationClient.getLastLocation();
  }
}
