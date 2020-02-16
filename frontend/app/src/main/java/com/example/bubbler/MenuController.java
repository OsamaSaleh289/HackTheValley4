package com.example.bubbler;

import android.Manifest;
import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import androidx.core.app.ActivityCompat;

public class MenuController implements View.OnClickListener {

  private int MY_PERMISSIONS_REQUEST_FINE_lOCATION = 1;
  private int MY_PERMISSIONS_REQUEST_COARSE_LOCATION = 2;
  private int MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION = 4;
  private int MY_PERMISSIONS_REQUEST_INTERNET = 3;

  private Context appContext;
  private Activity activity;

  public MenuController(Context context, Activity activity) {
    appContext = context;
    this.activity = activity;
  }

  private boolean checkPerms(Activity activity) {

    if (appContext.checkSelfPermission(permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // Permission is not granted
      // No explanation needed; request the permission
      ActivityCompat.requestPermissions(activity,
          new String[]{permission.ACCESS_FINE_LOCATION},
          MY_PERMISSIONS_REQUEST_FINE_lOCATION);

      return false;
    }
    if (appContext.checkSelfPermission(permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // Permission is not granted
      // No explanation needed; request the permission
      ActivityCompat.requestPermissions(activity,
          new String[]{permission.ACCESS_COARSE_LOCATION},
          MY_PERMISSIONS_REQUEST_COARSE_LOCATION);

      return false;
    }
    if (appContext.checkSelfPermission(permission.ACCESS_BACKGROUND_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // Permission is not granted
      // No explanation needed; request the permission
      ActivityCompat.requestPermissions(activity,
          new String[]{permission.ACCESS_BACKGROUND_LOCATION},
          MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION);

      return false;
    }
    if (appContext.checkSelfPermission(permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
      // Permission is not granted
      // No explanation needed; request the permission
      ActivityCompat.requestPermissions(activity,
          new String[]{permission.INTERNET},
          MY_PERMISSIONS_REQUEST_INTERNET);

      return false;
    }

    return true;
  }

  @Override
  public void onClick(View view) {
    Intent intent;
    switch (view.getId()) {
      case R.id.enter:
        intent = new Intent(this.appContext, BubbleView.class);
        if (checkPerms(activity)) {
          appContext.startActivity(intent);
        }
        break;
    }
  }
}
