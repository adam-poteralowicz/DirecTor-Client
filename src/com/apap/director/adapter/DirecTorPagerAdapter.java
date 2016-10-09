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

//    public Object instantiateItem(ViewGroup container, int position) {
//        LayoutInflater inflater = (LayoutInflater) container.getContext()
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        // Using different layouts in the view pager instead of images.
//
//        int resId = -1;
//
//        //Getting my layouts in my adapter. Three layouts defined.
//        switch (position) {
//            case 0:
//                resId = R.layout.contacts_view;
//                break;
//            case 1:
//                resId = R.layout.inbox_view;
//                break;
//
//        }
//
//        View view = inflater.inflate(resId, container, false);
//        ((ViewPager) container).addView(view, 0);
//        return view;
//
//        //return findViewById(redId);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView((View) object);
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }



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

