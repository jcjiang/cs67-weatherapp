package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ImageButton;

/**
 * Created by acaciah on 5/15/18.
 */

public class AddTilesActivity extends AppCompatActivity {

    private ImageView title;
    private ImageButton clothing;
    private ImageButton radar;
    private ImageButton air;
    private ImageButton done_button;
    // private Boolean hourly_expanded = false;
    // private Boolean daily_expanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tiles);

        setImages();
    }

//    protected void onCreate(Bundle savedInstanceState);
//
//    protected void onStart();
//
//    protected void onRestart();
//
//    protected void onResume();
//
//    protected void onPause();
//
//    protected void onStop();
//
//    protected void onDestroy();

    public void setImages() {
//        title= findViewById(R.id.title); // image
//
//        title.setImageResource(R.drawable.tiles_title);

        // clothing=(ImageButton) rootView.findViewById(R.id.clothing); //image

        clothing= findViewById(R.id.clothing); //image
        clothing.setImageResource(R.drawable.tiles_clothing);
        clothing.setAdjustViewBounds(true);

//        daily.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (!daily_expanded){
//                    daily.setImageResource(R.drawable.main_daily_expanded_boston);
//
//                } else{
//                    daily.setImageResource(R.drawable.main_daily_boston);
//                }
//                daily.setAdjustViewBounds(true);
//                daily_expanded=!daily_expanded;
//            }
//        });


        radar= findViewById(R.id.radar); //image
        radar.setImageResource(R.drawable.tiles_radar);
        radar.setAdjustViewBounds(true);

//        hourly.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if (!hourly_expanded){
//                    hourly.setImageResource(R.drawable.main_hourly_expanded_boston);
//                } else{
//                    hourly.setImageResource(R.drawable.main_hourly_boston);
//                }
//                hourly.setAdjustViewBounds(true);
//                hourly_expanded=!hourly_expanded;
//            }
//        });

        air = findViewById(R.id.air); //image
        air.setImageResource(R.drawable.tiles_air);
        air.setAdjustViewBounds(true);

        done_button = findViewById(R.id.done);
        done_button.setImageResource(R.drawable.done_2);
        done_button.setAdjustViewBounds(true);
//
//        done_button.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(view.getContext(), WeatherBostonFragment.);
//                startActivity(i);
//            }
//
//        });

        // return rootView;
    }

}
