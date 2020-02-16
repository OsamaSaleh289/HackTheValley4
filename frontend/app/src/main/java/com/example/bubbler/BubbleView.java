package com.example.bubbler;

import android.animation.ValueAnimator;
import android.location.Location;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BubbleView extends AppCompatActivity {

  private FusedLocationProviderClient fusedLocationClient;
  private Location curlocation;
  private LocationRequest locR;
  private LocationCallback loC;
  private Looper looper;
  private LocationResult locationResult;
  private boolean requestingLocationUpdates;
  private List msgs = new ArrayList<String>();
  private List bbls = new ArrayList<TextView>();
  private String placeholder = "kachow";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bubble_page);

    BubbleModel model = new BubbleModel(this);
    Intent intent = getIntent();
    Date time = (Date) intent.getSerializableExtra("Time");
    String content = (String) intent.getSerializableExtra("Content");

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
              curlocation = location;
              //first.setText(
              //    "Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            }
          }
        });
    loC = new LocationCallback() {
      @Override
      public void onLocationResult(LocationResult locationResult) {
        if (locationResult == null) {
          return;
        }
//        for (Location location : locationResult.getLocations()) {
//          second.setText(
//              "Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
//        }
        curlocation = locationResult.getLastLocation();
      }

      ;
    };
    createLocationRequest();
    startLocationUpdates();


    setUpMSGBBList(model.receive(curlocation));
    //post initial message
    if ((!content.isEmpty() && (curlocation != null))) {
      model.post(time, curlocation, content);
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (requestingLocationUpdates) {
      startLocationUpdates();
    }
  }

  private void startLocationUpdates() {
    fusedLocationClient.requestLocationUpdates(locR,
        loC,
        Looper.getMainLooper());
  }

  @Override
  protected void onPause() {
    super.onPause();
    stopLocationUpdates();
  }

  protected void createLocationRequest() {
    locR = LocationRequest.create();
    locR.setInterval(10000);
    locR.setFastestInterval(500);
    locR.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
  }

  private void stopLocationUpdates() {
    fusedLocationClient.removeLocationUpdates(loC);
  }


  private void setUpMSGBBList(List list) {
    bbls.add((TextView) (findViewById(R.id.first)));
    bbls.add((TextView) (findViewById(R.id.second)));
    bbls.add((TextView) (findViewById(R.id.third)));
    bbls.add((TextView) (findViewById(R.id.fourth)));
    bbls.add((TextView) (findViewById(R.id.fifth)));
    bbls.add((TextView) (findViewById(R.id.sixth)));
    bbls.add((TextView) (findViewById(R.id.seventh)));
    bbls.add((TextView) (findViewById(R.id.eighth)));
    bbls.add((TextView) (findViewById(R.id.ninth)));
    bbls.add((TextView) (findViewById(R.id.tenth)));

    msgs.addAll(list);
    txtTobbl();
  }

  private void txtTobbl() {
    for (Object tv : bbls) {
      if(!msgs.isEmpty()) {
        msgs.add(placeholder);
      }
        ((TextView) tv).setText((String) msgs.get(0));
        msgs.remove(0);
    }
  }
}
