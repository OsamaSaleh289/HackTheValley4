package com.example.bubbler;
import org.apache.commons.io.IOUtils;

import okhttp3.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Test{

  public static void main(String[] args) {

      URL url = null;
      try {
          url = new URL("https://na1.api.riotgames.com/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5?api_key=RGAPI-019a19a6-002c-4311-acd9-881288e0ca1b");
          HttpURLConnection urlConnection = null;
          urlConnection = (HttpURLConnection) url.openConnection();
          InputStream in = null;
          in = new BufferedInputStream(urlConnection.getInputStream());
          String myString = IOUtils.toString(in, "UTF-8");
          urlConnection.disconnect();
      } catch (MalformedURLException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
}
