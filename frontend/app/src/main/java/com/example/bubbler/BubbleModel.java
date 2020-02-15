package com.example.bubbler;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BubbleModel implements BubbleModelInterface, LocationListener {

  private Context context;
  protected LocationManager locationManager;
  protected LocationListener locationListener;
  protected boolean gps_enabled, network_enabled;
  protected Location location;

  protected BubbleModel(Context context) {
    locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

    if (context.checkSelfPermission(permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && context.checkSelfPermission(permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
      // Permission is not granted
      Toast.makeText(context, "allow location permission", Toast.LENGTH_LONG).show();
      gps_enabled = false;
      network_enabled = false;
    } else {
      //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

  }

  public void post(Time time, Location location, String content) {
    //send time, location, content to database
  }

  public void update(Location location) {
    //send location to database
  }

  public List receive(Location location) {
    //send location to database

    //receive a list of messages in radius (DUMMY)
    List<String> dummythicc = new ArrayList<String>();
    dummythicc.add("school sux");
    dummythicc.add("jupiter stoopiter");
    dummythicc.add("i love my wifeye");
    dummythicc.add("food is goood");
    dummythicc.add("utsc is :(");
    dummythicc.add(":flushed:");
    dummythicc.add("i dislike you!");
    dummythicc.add("oppa gangnam style");
    dummythicc.add("crazy crazy frog");
    dummythicc.add("bishishishih");
    dummythicc.add("lagnagvag");
    dummythicc.add("machupichu");
    dummythicc.add("ezay monay");
    dummythicc.add("i wanna home");
    dummythicc.add("Journeymap: press F");

    return dummythicc;
  }

  public String getLocationStr(){
    if(location != null) {
      return "Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude();
    }
    return "Location not yet set";

  }

  public Location getLocation() {
    return location;
  }

  @Override
  public void onLocationChanged(Location location) {
    this.location = location;
  }

  @Override
  public void onStatusChanged(String st, int in, Bundle bn) {
    Log.d("Latitude","status");
  }

  @Override
  public void onProviderEnabled(String st) {
    Log.d("Latitude","enable");
  }

  @Override
  public void onProviderDisabled(String st) {
    Log.d("Latitude","disable");
  }
}
