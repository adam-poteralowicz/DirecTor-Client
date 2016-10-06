package com.apap.director;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Adam on 2016-10-05.
 */
public class AuthUserActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);
    }

    public void onClick(View view) {
        /*
        opens the New Message screen
         */
        if (view.getId() == R.id.newMsgButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, NewMsgActivity.class);
            startActivityForResult(selectedIntent, 0003);
        }

        /*
        opens the Inbox screen
         */
        if (view.getId() == R.id.postLoginButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, InboxActivity.class);
            startActivityForResult(selectedIntent, 0004);
        }

        /*
        opens the Contacts List screen
         */
        if (view.getId() == R.id.postLoginButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, ContactsActivity.class);
            startActivityForResult(selectedIntent, 0005);
        }
    }
}
