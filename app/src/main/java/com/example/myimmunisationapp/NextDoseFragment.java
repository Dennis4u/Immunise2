package com.example.myimmunisationapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class NextDoseFragment extends Fragment  {

    View view;
    Button firstButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.dose_fragment, container, false);
// get the reference of Button
        firstButton = (Button) view.findViewById(R.id.firstButton);
// perform setOnClickListener on first Button
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                Toast.makeText(getActivity(), "Temperature", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}



