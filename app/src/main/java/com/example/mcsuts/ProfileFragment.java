package com.example.mcsuts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProfileFragment extends Fragment {

    Button logout;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);




        logout = view.findViewById(R.id.Profile_logout_btn);

        logout.setOnClickListener((e)->{
            Intent logoutIntent = new Intent(view.getContext(), LandingActivity.class);
            startActivity(logoutIntent);
        });

        return view;

    }
}