package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.CheckBox;
import android.view.View;
import android.util.Log;
import java.util.HashMap;

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

    private CheckBox clothing_checkbox, radar_checkbox, air_checkbox;

    private HashMap checkedHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tiles);

        checkedHashMap = new HashMap();
        setImages();
        // setCheckboxes();
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

        clothing= findViewById(R.id.clothing); //image
        clothing.setImageResource(R.drawable.tiles_clothing);
        clothing.setAdjustViewBounds(true);

        radar= findViewById(R.id.radar); //image
        radar.setImageResource(R.drawable.tiles_radar);
        radar.setAdjustViewBounds(true);

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

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        Log.d("tag","oncheckboxclicked");

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_clothing:
                if (checked) {
                    Log.d("tag","clothing checked");
                    checkedHashMap.put("clothing", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                // Put some meat on the sandwich
                else {
                    Log.d("tag","clothing not checked");
                    checkedHashMap.remove("clothing");
                    Log.d("tag", checkedHashMap.toString());
                }
                // Remove the meat
                break;
            case R.id.checkbox_radar:
                if (checked) {
                    Log.d("tag","radar checked");
                    checkedHashMap.put("radar", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                // Cheese me
                else {
                    Log.d("tag","radar not checked");
                    checkedHashMap.remove("radar");
                    Log.d("tag", checkedHashMap.toString());
                }
                // I'm lactose intolerant
                break;
            case R.id.checkbox_air:
                if (checked) {
                    Log.d("tag","air checked");
                    checkedHashMap.put("air", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                // Cheese me
                else {
                    Log.d("tag","air not checked");
                    checkedHashMap.remove("air");
                    Log.d("tag", checkedHashMap.toString());
                }
                break;
        }
    }

//    public void setCheckboxes() {
//        clothing_checkbox=(CheckBox)findViewById(R.id.checkbox_clothing);
//        radar_checkbox=(CheckBox)findViewById(R.id.checkbox_radar);
//        air_checkbox=(CheckBox)findViewById(R.id.checkbox_air);
//    }

}
