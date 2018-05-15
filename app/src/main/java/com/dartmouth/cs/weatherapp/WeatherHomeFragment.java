package com.dartmouth.cs.weatherapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;
/**
 * Created by acaciah on 5/11/18.
 */

public class WeatherHomeFragment extends Fragment {

    private Button settingsBtn;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weatherhome, container, false);





        return rootView;
    }

}
