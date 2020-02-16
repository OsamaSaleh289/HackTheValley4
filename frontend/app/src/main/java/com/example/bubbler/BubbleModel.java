package com.example.bubbler;

import android.content.Context;
import android.location.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BubbleModel implements BubbleModelInterface {

  private Context context;

  protected BubbleModel(Context context) {
    this.context = context;
  }

  public void post(Date time, Location location, String content) {
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
