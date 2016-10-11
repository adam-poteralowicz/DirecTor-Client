package com.apap.director.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.apap.director.R;

public class LoginActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        EditText usernameField = (EditText) findViewById(R.id.username);
        usernameField.setHint("USERNAME");
        EditText passwordField = (EditText) findViewById(R.id.passphrase);
        passwordField.setHint("PASSWORD");

    }

    public void onClick(View view) {
        // TODO: Save new user upon first login

        if (view.getId() == R.id.postLoginButton) {
            Intent selectedIntent = new Intent(LoginActivity.this, AuthUserActivity.class);
            startActivityForResult(selectedIntent, 0002);
        }
    }
}
