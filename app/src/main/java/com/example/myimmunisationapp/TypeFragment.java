package com.example.myimmunisationapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TypeFragment extends Fragment {
    View view;
    Button thirdButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.type_fragment, container, false);
// get the reference of Button
        thirdButton = (Button) view.findViewById(R.id.thirdButton);
// perform setOnClickListener on second Button
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                Toast.makeText(getActivity(), "About", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}

