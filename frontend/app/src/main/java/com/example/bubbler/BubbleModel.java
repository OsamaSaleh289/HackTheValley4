package com.example.bubbler;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BubbleModel implements BubbleModelInterface {

  private Context context;
  protected LocationManager locationManager;
  protected boolean gps_enabled, network_enabled;

  protected BubbleModel(Context context) {
    this.context = context;
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
}
