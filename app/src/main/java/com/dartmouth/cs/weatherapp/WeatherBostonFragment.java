package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.content.Intent;

import java.util.HashMap;

/**
 * Created by acaciah on 5/11/18.
 */

public class WeatherBostonFragment extends Fragment {

    private ImageButton hourly;
    private ImageButton daily;
    private ImageButton add_button;
    private Boolean hourly_expanded = false;
    private Boolean daily_expanded = false;

    private ImageView clothing, radar, air;
    private Boolean radar_expanded = false;
    private HashMap addedTiles;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weatherboston, container, false);

        // get the added tiles from main activity
        MainActivity activity = (MainActivity) getActivity();
        addedTiles = activity.bostonAddedTiles;

        ImageView title=(ImageView) rootView.findViewById(R.id.title); // image
        title.setImageResource(R.drawable.main_title_boston);

        daily=(ImageButton) rootView.findViewById(R.id.daily); //image
        daily.setImageResource(R.drawable.main_daily_boston);
        daily.setAdjustViewBounds(true);

        daily.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!daily_expanded){
                    daily.setImageResource(R.drawable.main_daily_expanded_boston);

                } else{
                    daily.setImageResource(R.drawable.main_daily_boston);
                }
                daily.setAdjustViewBounds(true);
                daily_expanded=!daily_expanded;
            }
        });

        ImageView sun=(ImageView) rootView.findViewById(R.id.sun); // image
        sun.setImageResource(R.drawable.main_sun);

        hourly=(ImageButton) rootView.findViewById(R.id.hourly); //image
        hourly.setImageResource(R.drawable.main_hourly_boston);
        hourly.setAdjustViewBounds(true);

        hourly.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!hourly_expanded){
                    hourly.setImageResource(R.drawable.main_hourly_expanded_boston);
                } else{
                    hourly.setImageResource(R.drawable.main_hourly_boston);
                }
                hourly.setAdjustViewBounds(true);
                hourly_expanded=!hourly_expanded;
            }
        });


        add_button = (ImageButton) rootView.findViewById(R.id.add_button);

        add_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AddTilesActivity.class);
                i.putExtra("SENT_FROM", "boston");
                startActivity(i);
            }

        });

        clothing = rootView.findViewById(R.id.boston_clothing); //image
        radar = rootView.findViewById(R.id.boston_radar); //image
        air = rootView.findViewById(R.id.boston_air); //image


        if (addedTiles != null) {
            // add custom tiles
            if (addedTiles.containsKey("clothing")) {
                Log.d("weatherbostonfrag", "clothing");
                clothing.setImageResource(R.drawable.main_clothing);
                clothing.setAdjustViewBounds(true);
            }
            if (addedTiles.containsKey("radar")) {
                Log.d("weatherbostonfrag", "radar");
                radar.setImageResource(R.drawable.main_radar);
                radar.setAdjustViewBounds(true);
                radar.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Log.d("", "radar onclick");
                        if (!radar_expanded) {
                            Log.d("", "radar onclick not expanded");
                            radar.setImageResource(R.drawable.main_radar_expanded);
                        } else {
                            Log.d("", "radar onclick expanded");
                            radar.setImageResource(R.drawable.main_radar);
                        }
                        radar.setAdjustViewBounds(true);
                        radar_expanded = !radar_expanded;
                    }

                });


            }
            if (addedTiles.containsKey("air")) {
                Log.d("weatherbostonfrag", "air");
                air.setImageResource(R.drawable.main_air);
                air.setAdjustViewBounds(true);

            }
        }


        return rootView;
    }


}
