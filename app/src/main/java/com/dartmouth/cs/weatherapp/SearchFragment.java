package com.dartmouth.cs.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageButton;


/**
 * Created by acaciah on 5/11/18.
 */

public class SearchFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        ImageView imageViewHanover=(ImageView) rootView.findViewById(R.id.search_hanover); //cat image
        imageViewHanover.setImageResource(R.drawable.search_hanover);
        ImageView imageViewBoston=(ImageView) rootView.findViewById(R.id.search_boston); //cat image
        imageViewBoston.setImageResource(R.drawable.search_boston);
        ImageView imageViewCF=(ImageView) rootView.findViewById(R.id.cf); //cat image
        imageViewCF.setImageResource(R.drawable.search_cf);

        ImageView imageViewAddBtn =(ImageView) rootView.findViewById(R.id.add_button); //cat image
        imageViewAddBtn.setImageResource(R.drawable.add_button);


        return rootView;
    }


}






