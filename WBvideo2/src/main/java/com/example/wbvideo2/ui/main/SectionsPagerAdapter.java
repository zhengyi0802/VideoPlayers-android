package com.example.wbvideo2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    //@StringRes
    //private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};


    private final Context mContext;
    private ArrayList<String> mList;

    public SectionsPagerAdapter(Context context, FragmentManager fm, ArrayList<String> urls) {
        super(fm);
        mContext = context;
        mList = urls;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1, mList.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Integer.toString(position+1);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return mList.size();
    }
}