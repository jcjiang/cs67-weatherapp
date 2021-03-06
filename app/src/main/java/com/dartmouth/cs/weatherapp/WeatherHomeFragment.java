package com.dartmouth.cs.weatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.util.Log;
import java.util.HashMap;

/**
 * Created by acaciah on 5/11/18.
 */

public class WeatherHomeFragment extends Fragment {

    private ImageButton hourly;
    private ImageButton daily;
    private ImageButton add_button;
    private Boolean hourly_expanded = false;
    private Boolean daily_expanded = false;

    private ImageView clothing, radar, air;
    private Boolean radar_expanded = false;
    private HashMap addedTiles;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weatherhome, container, false);

        // get the added tiles from main activity
        MainActivity activity = (MainActivity) getActivity();
        addedTiles = activity.homeAddedTiles;

        Log.d("home", "oncreateview");

        ImageView title = (ImageView) rootView.findViewById(R.id.title); // image
        title.setImageResource(R.drawable.main_title_hanover);

        daily = (ImageButton) rootView.findViewById(R.id.daily); //image
        daily.setImageResource(R.drawable.main_daily_hanover);
        daily.setAdjustViewBounds(true);

        daily.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!daily_expanded) {
                    daily.setImageResource(R.drawable.main_daily_expanded_hanover);

                } else {
                    daily.setImageResource(R.drawable.main_daily_hanover);
                }
                daily.setAdjustViewBounds(true);
                daily_expanded = !daily_expanded;
            }
        });

        ImageView sun = (ImageView) rootView.findViewById(R.id.sun); // image
        sun.setImageResource(R.drawable.main_sun);

        hourly = (ImageButton) rootView.findViewById(R.id.hourly); //image
        hourly.setImageResource(R.drawable.main_hourly_hanover);
        hourly.setAdjustViewBounds(true);

        hourly.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!hourly_expanded) {
                    hourly.setImageResource(R.drawable.main_hourly_expanded_hanover);
                } else {
                    hourly.setImageResource(R.drawable.main_hourly_hanover);
                }
                hourly.setAdjustViewBounds(true);
                hourly_expanded = !hourly_expanded;
            }

        });


        add_button = (ImageButton) rootView.findViewById(R.id.add_button);

        add_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddTilesActivity.class);
                i.putExtra("SENT_FROM", "hanover");
                startActivity(i);
            }

        });

        clothing = rootView.findViewById(R.id.home_clothing); //image
        radar = rootView.findViewById(R.id.home_radar); //image
        air = rootView.findViewById(R.id.home_air); //image


        if (addedTiles != null) {
            // add custom tiles
            if (addedTiles.containsKey("clothing")) {
                // Log.d("weatherhomefrag", "clothing");
                clothing.setImageResource(R.drawable.main_clothing);
                clothing.setAdjustViewBounds(true);
            }
            if (addedTiles.containsKey("radar")) {
                // Log.d("weatherhomefrag", "radar");
                radar.setImageResource(R.drawable.main_radar);
                radar.setAdjustViewBounds(true);
                radar.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // Log.d("", "radar onclick");
                        if (!radar_expanded) {
                         //    Log.d("", "radar onclick not expanded");
                            radar.setImageResource(R.drawable.main_radar_expanded);
                        } else {
                        //    Log.d("", "radar onclick expanded");
                            radar.setImageResource(R.drawable.main_radar);
                        }
                        radar.setAdjustViewBounds(true);
                        radar_expanded = !radar_expanded;
                    }

                });


            }
            if (addedTiles.containsKey("air")) {
                // Log.d("weatherhomefrag", "air");
                air.setImageResource(R.drawable.main_air);
                air.setAdjustViewBounds(true);

            }
        }

        return rootView;
    }



//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        if (savedInstanceState != null) {
//            // Restore value of members from saved state
//            Log.d("home onrestore", "");
//            addedTiles = (HashMap) savedInstanceState.getSerializable("addTiles");
//            Log.d("home onrestore", addedTiles.toString());
//        }
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        Log.d("weather home", "onsaveinstancestate");
//        savedInstanceState.putSerializable("addTiles", addedTiles);
//        // Always call the superclass so it can save the view hierarchy state
//        super.onSaveInstanceState(savedInstanceState);
//    }

}