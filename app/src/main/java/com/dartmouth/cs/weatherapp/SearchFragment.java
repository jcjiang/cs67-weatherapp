package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by acaciah on 5/11/18.
 */

public class SearchFragment extends Fragment {
    String[] places = {"Boston", "New York", "Hanover", "Lebanon", "Enfield"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        ImageView imageViewHanover=(ImageView) rootView.findViewById(R.id.weatherHanover); //cat image
        imageViewHanover.setImageResource(R.drawable.weather_hanover);
        ImageView imageViewBoston=(ImageView) rootView.findViewById(R.id.weatherBoston); //cat image
        imageViewBoston.setImageResource(R.drawable.weather_boston);



        return rootView;
    }

}





