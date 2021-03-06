package com.example.bubbler;

import android.content.Context;
import android.widget.EditText;

import com.example.bubbler.LoginAndAccount.WriteAndCheck;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPresenter{

    private WriteAndCheck wac;

    public LoginPresenter() {
        wac = new WriteAndCheck();
    }

    public boolean validateCredentialsForAccountCreation(Context context, String username, String password,
                                                         EditText editTextUser, EditText editTextPass) {
        if (checkText(editTextUser) && checkText(editTextPass)) {
            ArrayList<Boolean> arr = wac.checkUsernameAndPassword(context, username, password);
            if (arr.get(0)) {
                editTextUser.setError("Username already exists");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }


    public boolean validateCredentialsForLogin(Context context, String username, String password, EditText editTextUser, EditText editTextPass) {
        if (checkText(editTextUser) && checkText(editTextPass)) {
            ArrayList<Boolean> validation = wac.checkUsernameAndPassword(context, username, password);
            if (validation.get(0)) {
                if (!(validation.get(1))) {
                    editTextPass.setError("Incorrect Password");
                    return false;
                }
            } else {
                editTextUser.setError("Username does not exist");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * @param editText which contains the text to be checked
     * @return true if the text entered by the user is correct and false otherwise
     */

    private boolean checkText(EditText editText) {
        String check = editText.getText().toString();
        Pattern newPattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher newMatcher = newPattern.matcher(check);
        if (newMatcher.matches()) {
            return true;
        } else {
            editText.setError("Only alphanumeric characters are allowed");
            return false;
        }
    }
}
