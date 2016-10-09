package com.apap.director.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.apap.director.App;
import com.apap.director.R;

public class DirecTorPagerAdapter extends FragmentPagerAdapter {
    AuthUserActivity aua = new AuthUserActivity();

    public DirecTorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ContactsFragment();
            case 1:
                return new InboxFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        String contacts = App.getContext().getResources().getString(R.string.title_section_1).toUpperCase();
        String inbox = App.getContext().getResources().getString(R.string.title_section_2).toUpperCase();

        System.out.println("Contacts: "+contacts);
        System.out.println("Inbox: "+inbox);

        switch (position) {
            case 0:
                return contacts;
            case 1:
                return inbox;
        }
        return null;
    }
}

