package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by acaciah on 5/11/18.
 */

public class SearchFragment extends Fragment {
    String[] places = {"Boston", "New York", "Hanover", "Lebanon", "Enfield"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);



        return rootView;
    }

}
