package com.example.bubbler;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MenuController implements View.OnClickListener{

  private Context appContext;

  public MenuController(Context context){appContext = context;}

  @Override
  public void onClick(View view){
    Intent intent;
    switch(view.getId()) {
      case R.id.enter:
        intent = new Intent(this.appContext, BubbleView.class);
        appContext.startActivity(intent);
        break;
    }
  }
}
