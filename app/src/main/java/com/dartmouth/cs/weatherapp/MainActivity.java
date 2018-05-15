package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

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


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
