package com.apap.director.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.adapter.DirecTorPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Adam on 2016-10-05.
 */
public class AuthUserActivity extends FragmentActivity {
    DirecTorPagerAdapter direcTorPagerAdapter;
    ViewPager viewPager;
    public static boolean NEW_CONTACT_ADDED = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);

        direcTorPagerAdapter = new DirecTorPagerAdapter(getSupportFragmentManager(), 2);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(direcTorPagerAdapter);
    }


    public void onClick(View view) {

        if (view.getId() == R.id.addNewContactButton) {
            Intent selectedIntent = new Intent(AuthUserActivity.this, AddContactActivity.class);
            startActivityForResult(selectedIntent, 0010);
        }
    }

    public ArrayList<String> getContacts() {

        ArrayList<String> contacts = getIntent().getStringArrayListExtra("contacts");
            if (contacts == null) {
                return null;
            }

        return contacts;
    }

    public String getNewContact() {
        String newContact = getIntent().getStringExtra("newContactName");
        if (newContact == null) {
            return null;
        }

        Toast.makeText(App.getContext(), "NEW CONTACT ADDED!", Toast.LENGTH_LONG).show();
        NEW_CONTACT_ADDED = true;

        return newContact;
    }




}

