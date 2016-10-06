package com.apap.director;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartingActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View view) {
        /*
        opens the Login screen
         */
        if (view.getId() == R.id.loginButton) {
            Intent selectedIntent = new Intent(StartingActivity.this, LoginActivity.class);
            startActivityForResult(selectedIntent, 0001);
        }
    }
}
