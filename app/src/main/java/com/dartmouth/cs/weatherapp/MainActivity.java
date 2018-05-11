package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.dartmouth.cs.weatherapp.WeatherHomeFragment;
import com.dartmouth.cs.weatherapp.SearchFragment;
import com.dartmouth.cs.weatherapp.WeatherBostonFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ViewPager mViewPager;
    private ArrayList<Fragment> fragments;

    public void changeTab(int page) {
        mViewPager.setCurrentItem(page);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        fragments = new ArrayList<Fragment>();
        fragments.add(new SearchFragment());
        fragments.add(new WeatherHomeFragment());
        fragments.add(new WeatherBostonFragment());



    }
}
