package com.example.bubbler;

import android.content.Context;
import android.location.Location;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BubbleModel implements BubbleModelInterface {

  private Context context;

  protected BubbleModel(Context context) {
    this.context = context;
  }

  public void post(Date time, Location location, String content) throws MalformedURLException, IOException {
    double latitude = location.getLatitude();
    double longitutde = location.getLongitude();
    //send time, location, content to database
    try{
      URL reqURL = new URL("https://bubme.herokuapp.com/"); //the URL we will send the request to
      HttpURLConnection request = (HttpURLConnection) (reqURL.openConnection());
      //String post = "this will be the post data that you will send";
      request.setDoOutput(true);
      //request.addRequestProperty("Content-Length", Integer.toString(post.length())); //add the content length of the post data
      //request.addRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //add the content type of the request, most post data is of this type
      request.setRequestMethod("POST");
      request.connect();
      OutputStreamWriter writer = new OutputStreamWriter(request.getOutputStream()); //we will write our request data here
      writer.write(content);
      writer.flush();
    }catch (MalformedURLException e){
      e.printStackTrace();
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  public void update(Location location) {
    //send location to database
  }

  public List receive(Location location) {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        try  {
          URL url = new URL("https://bubme.herokuapp.com/get?user=Osama&lat=100&lon=100");
          HttpURLConnection urlConnection = null;
          urlConnection = (HttpURLConnection) url.openConnection();
          InputStream in = null;
          InputStream is= urlConnection.getInputStream();
          in = new BufferedInputStream(is);
          String myString = IOUtils.toString(in, "UTF-8");
          System.out.println(myString);
          urlConnection.disconnect();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    thread.start();
    //send location to database

    //receive a list of messages in radius (DUMMY)
    List<String> dummythicc = new ArrayList<String>();
    dummythicc.add("school cool");
    dummythicc.add("jupiter stoopiter");
    dummythicc.add("i love my wifeye");
    dummythicc.add("food is goood");
    dummythicc.add("utsc is :>");
    dummythicc.add(":flushed:");
    dummythicc.add("i dislike you!!!!");
    dummythicc.add("oppa gangnam style");
    dummythicc.add("crazy crazy frog");
    dummythicc.add("bishishishihoppo");
    dummythicc.add("lagnagvag");
    dummythicc.add("machupichu");
    dummythicc.add("ezay monay");
    dummythicc.add("i wanna home");
    dummythicc.add("Journeymap: press F");

    return dummythicc;
  }
}
