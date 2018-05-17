package com.dartmouth.cs.weatherapp;

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
/**
 *
 * Created by acaciah on 5/15/18.
 */

public class AddTilesActivity extends AppCompatActivity {

    private ImageButton clothing;
    private ImageButton radar;
    private ImageButton air;
    private ImageButton done_button;

    private HashMap checkedHashMap;

    private String sent_from; // fragment the intent came from (aka boston or hanover)
    private Context thisContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tiles);

        checkedHashMap = new HashMap();
        setImages();
        // setCheckboxes();

        sent_from = getIntent().getStringExtra("SENT_FROM");
        Log.d("sent from", sent_from);
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
        Intent intent = new Intent(this, WeatherHomeFragment.class);

        thisContext = this;
        done_button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // send data from activity to fragment:
                // https://stackoverflow.com/questions/12739909/send-data-from-activity-to-fragment-in-android
                Bundle bundle = new Bundle();
//                // bundle.putString("edttext");
//
//                // put hashmap in bundle https://stackoverflow.com/questions/11452859/android-hashmap-in-bundle
                bundle.putSerializable("checkedHashmap", checkedHashMap);
                // set Fragmentclass Arguments


//                Intent intent = Intent(this, MainActivity.class);
//                startActivity(intent);
//                finish();

                if (sent_from.equals("hanover")){
                    Intent intent = new Intent(thisContext, MainActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra("SEND_TO", "hanover");
                    startActivity(intent);
                    finish();

                }
                else if (sent_from.equals("boston")){
                    Intent intent = new Intent(thisContext, MainActivity.class);
                    intent.putExtras(bundle);
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

        Log.d("tag","oncheckboxclicked");

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_clothing:
                if (checked) {
                    Log.d("tag","clothing checked");
                    checkedHashMap.put("clothing", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                else {
                    Log.d("tag","clothing not checked");
                    checkedHashMap.remove("clothing");
                    Log.d("tag", checkedHashMap.toString());
                }
                break;
            case R.id.checkbox_radar:
                if (checked) {
                    Log.d("tag","radar checked");
                    checkedHashMap.put("radar", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                else {
                    Log.d("tag","radar not checked");
                    checkedHashMap.remove("radar");
                    Log.d("tag", checkedHashMap.toString());
                }
                break;
            case R.id.checkbox_air:
                if (checked) {
                    Log.d("tag","air checked");
                    checkedHashMap.put("air", "checked");
                    Log.d("tag", checkedHashMap.toString());
                }
                else {
                    Log.d("tag","air not checked");
                    checkedHashMap.remove("air");
                    Log.d("tag", checkedHashMap.toString());
                }
                break;
        }
    }


}
