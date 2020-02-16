package com.example.bubbler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bubbler.LoginAndAccount.WriteAndCheck;


public class CreateAccountActivity extends AppCompatActivity {
    private LoginPresenter loginPresenter;
    private WriteAndCheck wac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Intent intent = getIntent();
        loginPresenter = new LoginPresenter();
        wac = new WriteAndCheck();

    }



    public void DoneButton(View view) {
        EditText editTextUsername = findViewById(R.id.answerEditText);
        EditText editTextPassword = findViewById(R.id.editText3);
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if (loginPresenter.validateCredentialsForAccountCreation(getApplicationContext(), username,
                password, editTextUsername, editTextPassword)) {
            wac.writeInfoToFile(getApplicationContext(), username, password, "UserFile");
            finish();
        }
    }


}
