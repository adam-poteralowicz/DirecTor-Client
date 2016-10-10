package com.apap.director.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.apap.director.App;
import com.apap.director.R;
import com.apap.director.fragment.ContactsFragment;
import com.apap.director.fragment.InboxFragment;

public class DirecTorPagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;

    public DirecTorPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.mNumOfTabs = numTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ContactsFragment();
            case 1:
                return new InboxFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }



    @Override
    public CharSequence getPageTitle(int position) {

        String contacts = App.getContext().getResources().getString(R.string.title_section_1).toUpperCase();
        String inbox = App.getContext().getResources().getString(R.string.title_section_2).toUpperCase();

        switch (position) {
            case 0:
                return contacts;
            case 1:
                return inbox;
        }
        return null;
    }
}

