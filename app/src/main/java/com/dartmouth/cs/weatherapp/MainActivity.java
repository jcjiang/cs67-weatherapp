package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ViewPager ViewPager;
    private ArrayList<Fragment> fragments;

    private SlidingTabLayoutWeather slidingTabLayoutWeather;
    private ViewPageAdapter ViewPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager = (ViewPager) findViewById(R.id.viewpager);
        slidingTabLayoutWeather = (SlidingTabLayoutWeather) findViewById(R.id.tab);



//        FragmentManager fm = getSupportFragmentManager();
//        Fragment_Pager pagerAdapter = new Fragment_Pager(fm);
//        // Here you would declare which page to visit on creation
//        pager.setAdapter(pagerAdapter);
//        pager.setCurrentItem(1);

        fragments = new ArrayList<Fragment>();
        fragments.add(new SearchFragment());
        fragments.add(new WeatherHomeFragment());
        fragments.add(new WeatherBostonFragment());


        ViewPageAdapter = new myFragmentPagerAdaptor(getSupportFragmentManager(), fragments);
        ViewPager.setAdapter(ViewPageAdapter);
        ViewPager.setCurrentItem(1); // sets note fragment to default


        slidingTabLayoutWeather.setDistributeEvenly(true);
        slidingTabLayoutWeather.setViewPager(ViewPager);


    }


    public static class myFragmentPagerAdaptor extends ViewPageAdapter {

        public myFragmentPagerAdaptor(FragmentManager fm, ArrayList al) {
            super(fm, al);
        }

        @Override
        public int getItemPosition(Object object) {
            // POSITION_NONE makes it possible to reload the PagerAdapter
            Log.d("TEST", "RETURNED NONE");
            return POSITION_NONE;
        }
    }

}
