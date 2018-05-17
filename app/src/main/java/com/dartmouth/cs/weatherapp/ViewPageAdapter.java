package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

/**
 * Created by acaciah on 5/15/18.
 */

public class ViewPageAdapter extends FragmentPagerAdapter{

    public ArrayList<Fragment> fragments; // made public to add tiles
    public ViewPageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;



//        setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                Toast.makeText(getApplicationContext(),"tells us anything? "+mViewPageAdapter.getItem(position).getId() ,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),"tells us anything? "+mViewPageAdapter.getItem(position).getClass().getName() ,Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),"tells us anything? "+mViewPageAdapter.getItem(position).getClass().isInstance(new NoteListFragment()) ,Toast.LENGTH_SHORT).show();
//
//
//                if (mViewPageAdapter.getItem(position).getId() == 2){
//                    mViewPageAdapter.getItem(1).onResume();
//                }
//            }
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {}
//            @Override
//            public void onPageScrollStateChanged(int arg0) {}
//        });
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "search";
            case 1:
                return "home";
            case 2:
                return "boston";
            default:
                break;
        }
        return null;

    }

    @Override
    public int getItemPosition(Object object) {

        return POSITION_NONE;
    }


}
