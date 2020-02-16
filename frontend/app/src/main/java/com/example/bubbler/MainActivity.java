package com.example.bubbler;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.bubbler.LoginAndAccount.WriteAndCheck;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private LoginPresenter loginPresenter;
    private WriteAndCheck wac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter();
        wac = new WriteAndCheck();

    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }


    public void LoginButton(View view) {
        Intent intent = new Intent(this, HomePage.class);
        EditText editTextUser = findViewById(R.id.editText1);
        EditText editTextPass = findViewById(R.id.editText);
        String username = editTextUser.getText().toString();
        String password = editTextPass.getText().toString();
        if (loginPresenter.validateCredentialsForLogin(getApplicationContext(), username, password,
                editTextUser, editTextPass)) {

            intent.putExtra("Username", username);
            startActivity(intent);
        }
    }

    public void exitApplication(View view) {
        moveTaskToBack(true);
    }


}
