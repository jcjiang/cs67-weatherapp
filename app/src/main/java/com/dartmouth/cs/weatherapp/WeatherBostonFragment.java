package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.content.Intent;

/**
 * Created by acaciah on 5/11/18.
 */

public class WeatherBostonFragment extends Fragment {

    private ImageButton hourly;
    private ImageButton daily;
    private ImageButton add_button;
    private Boolean hourly_expanded = false;
    private Boolean daily_expanded = false;

    // private Boolean clothing_added;
    // private Boolean radar_added;
    // private Boolean air_added;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weatherboston, container, false);

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

//        ImageView daily=(ImageView) rootView.findViewById(R.id.daily); // image
//        daily.setImageResource(R.drawable.main_daily_boston);

//        ImageView hourly=(ImageView) rootView.findViewById(R.id.hourly); //image
//        hourly.setImageResource(R.drawable.main_hourly_boston);

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
                startActivity(i);
            }

        });

        return rootView;
    }


}
