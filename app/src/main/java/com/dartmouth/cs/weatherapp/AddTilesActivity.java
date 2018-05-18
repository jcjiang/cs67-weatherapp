package com.dartmouth.cs.weatherapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.widget.CheckBox;
import android.view.View;
import android.util.Log;
import java.util.HashMap;
import android.view.View.OnClickListener;
import android.support.v4.app.FragmentTransaction;

import android.content.Intent;
import android.content.Context;

import com.google.gson.Gson;

/**
 *
 * Created by acaciah on 5/15/18.
 */

public class AddTilesActivity extends AppCompatActivity {

    private ImageButton clothing;
    private ImageButton radar;
    private ImageButton air;
    private ImageButton done_button;

    private Boolean clothing_expanded = false;

    private HashMap checkedHashMap;
    private HashMap homeHashMap;
    private HashMap bostonHashMap;

    private String sent_from; // fragment the intent came from (aka boston or hanover)
    private Context thisContext;
    private static String SHARED_PREF = "my_sharedpref"; // shared preferences


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tiles);

        checkedHashMap = new HashMap();

        setImages();

        sent_from = getIntent().getStringExtra("SENT_FROM");
        // Log.d("sent from", sent_from);
    }


    public void setImages() {

        clothing= findViewById(R.id.clothing); //image
        clothing.setImageResource(R.drawable.tiles_clothing);
        clothing.setAdjustViewBounds(true);
        clothing.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!clothing_expanded){
                    clothing.setImageResource(R.drawable.tiles_clothing_expanded);
                } else{
                    clothing.setImageResource(R.drawable.tiles_clothing);
                }
                clothing.setAdjustViewBounds(true);
                clothing_expanded=!clothing_expanded;
            }

        });

        radar= findViewById(R.id.radar); //image
        radar.setImageResource(R.drawable.tiles_radar);
        radar.setAdjustViewBounds(true);

        air = findViewById(R.id.air); //image
        air.setImageResource(R.drawable.tiles_air);
        air.setAdjustViewBounds(true);

        done_button = findViewById(R.id.done);
        done_button.setImageResource(R.drawable.done_2);
        done_button.setAdjustViewBounds(true);
        Intent intent = new Intent(this, WeatherHomeFragment.class);

        thisContext = this;
        done_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // send data from activity to fragment:
                // https://stackoverflow.com/questions/12739909/send-data-from-activity-to-fragment-in-android
                // put hashmap in bundle https://stackoverflow.com/questions/11452859/android-hashmap-in-bundle

                Bundle bundle = new Bundle();
                bundle.putSerializable("checkedHashmap", checkedHashMap);

                // save to shared prefs
                //convert to string using gson
                Gson gson = new Gson();
                String hashMapString = gson.toJson(checkedHashMap);
//                String bostonMapString = gson.toJson(checkedHashMap);

                //save in shared prefs
                SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);


//                prefs.edit().putString("bostontiles", hashMapString).apply();
//                String storedHashMapString = prefs.getString("hanovertiles", "default");
//                Log.d("addtiles shared prefs",storedHashMapString);


                if (sent_from.equals("hanover")){

                    prefs.edit().putString("hanovertiles", hashMapString).apply();
                    // String storedHashMapString = prefs.getString("hanovertiles", "default");

                    // navigate back to main activity
                    Intent intent = new Intent(thisContext, MainActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra("SEND_TO", "hanover");
                    startActivity(intent);
                    finish();

                }
                else if (sent_from.equals("boston")){

                    //save in shared prefs
                    // SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                    prefs.edit().putString("bostontiles", hashMapString).apply();


                    Intent intent = new Intent(thisContext, MainActivity.class);
                    // intent.putExtras(bundle);
                    intent.putExtra("SEND_TO", "boston");
                    startActivity(intent);
                    finish();
                }

            }

        });

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Log.d("tag","oncheckboxclicked");

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_clothing:
                if (checked) {
                    // Log.d("tag","clothing checked");
                    checkedHashMap.put("clothing", "checked");
                    // Log.d("tag", checkedHashMap.toString());
                }
                else {
                   // Log.d("tag","clothing not checked");
                    checkedHashMap.remove("clothing");
                   // Log.d("tag", checkedHashMap.toString());
                }
                break;
            case R.id.checkbox_radar:
                if (checked) {
                    // Log.d("tag","radar checked");
                    checkedHashMap.put("radar", "checked");
                    // Log.d("tag", checkedHashMap.toString());
                }
                else {
                    // Log.d("tag","radar not checked");
                    checkedHashMap.remove("radar");
                   // Log.d("tag", checkedHashMap.toString());
                }
                break;
            case R.id.checkbox_air:
                if (checked) {
                    // Log.d("tag","air checked");
                    checkedHashMap.put("air", "checked");
                    // Log.d("tag", checkedHashMap.toString());
                }
                else {
                    // Log.d("tag","air not checked");
                    checkedHashMap.remove("air");
                    // Log.d("tag", checkedHashMap.toString());
                }
                break;
        }
    }


}
