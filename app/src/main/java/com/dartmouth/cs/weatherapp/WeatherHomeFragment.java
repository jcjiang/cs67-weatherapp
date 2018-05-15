package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by acaciah on 5/11/18.
 */

public class WeatherHomeFragment extends Fragment {

    private Button settingsBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weatherhome, container, false);

        ImageView title=(ImageView) rootView.findViewById(R.id.title); //cat image
        title.setImageResource(R.drawable.weather);

        ImageView daily=(ImageView) rootView.findViewById(R.id.daily); //cat image
        daily.setImageResource(R.drawable.main_daily);







        return rootView;
    }

}
