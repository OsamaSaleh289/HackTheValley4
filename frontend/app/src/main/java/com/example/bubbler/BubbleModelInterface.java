package com.example.bubbler;

import android.location.Location;
import java.sql.Time;
import java.util.List;

public interface BubbleModelInterface {

  /**
   * takes the user's message and puts it into the database
   * with time, location, content, user_id, and post_id?
   * @param time time of the message
   * @param location location of user
   * @param content content of message
   */
  public void post(Time time, Location location, String content);

  /**
   * takes the user's location, user_id, and post_id?
   * and updates the user's location in the database
   * should be called often enough as user relocates
   * @param location location of user
   */
  public void update(Location location);

  /**
   * takes the user's location, user_id, and post_id?
   * and returns a list of messages from users in a local
   * radius to bubble up on the screen
   * @param location location of user
   * @return a list of messages from local radius
   */
  public List receive(Location location);
}
