package com.apap.director.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.apap.director.R;

/**
 * Created by Adam on 2016-10-05.
 */
public class AuthUserActivity extends FragmentActivity {
    DirecTorPagerAdapter direcTorPagerAdapter;
    ViewPager viewPager;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);

        direcTorPagerAdapter = new DirecTorPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(direcTorPagerAdapter);

    }

    public void onClick(View view) {
        /*
        opens the Inbox screen
         */
        if (view.getId() == R.id.inboxButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, InboxActivity.class);
            startActivityForResult(selectedIntent, 0003);
        }

        /*
        opens the Contacts List screen
         */
        if (view.getId() == R.id.contactsButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, ContactsActivity.class);
            startActivityForResult(selectedIntent, 0004);
        }
    }

}

