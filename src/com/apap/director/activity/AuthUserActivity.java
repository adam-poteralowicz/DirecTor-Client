package com.apap.director.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.apap.director.R;
import com.apap.director.adapter.DirecTorPagerAdapter;

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

        direcTorPagerAdapter = new DirecTorPagerAdapter(getSupportFragmentManager(), 2);
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(direcTorPagerAdapter);


    }


}

