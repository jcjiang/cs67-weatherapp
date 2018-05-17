package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v4.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    public ViewPager ViewPager;
    public ArrayList<Fragment> fragments; // used to be private. need public to add tiles

    public SlidingTabLayoutWeather slidingTabLayoutWeather;
    public ViewPageAdapter ViewPageAdapter; // used to be private. need public to add tiles
    public HashMap bostonAddedTiles;
    public HashMap homeAddedTiles; // aka hanover

    public String sendTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();

        if(bundle != null) {
            HashMap checkedHashMap = (HashMap) bundle.getSerializable("checkedHashmap");
            Log.d("hashmap mainactivity", checkedHashMap.toString());
            sendTo = (String) bundle.getString("SEND_TO");
            Log.d("sendTo mainactivity", sendTo);
            if (sendTo.equals("hanover")){
                homeAddedTiles = checkedHashMap;
            } else if (sendTo.equals("boston")) {
                bostonAddedTiles = checkedHashMap;
            }

        }

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
