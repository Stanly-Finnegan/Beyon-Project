package com.example.mcsuts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcsuts.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {


    TextView uname, email, phone;
    Button logout;
    SharedPreferences sharedPreferences;

    int loginID;

    static List<UserModel> user = LoginActivity.user;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);



        uname = view.findViewById(R.id.Profile_Uname_text);
        email = view.findViewById(R.id.Profile_Email_text);
        phone = view.findViewById(R.id.Profile_Phone_text);


        loginID = LoginActivity.loginId-1;

        Log.wtf("Login Test", ""+loginID);
//
//
//        int i = 0;
//        for(UserModel userModel : user){
//            Log.wtf("Test -"+i++, "id"+userModel.getId()+ " LoginID"+login+" email: "+userModel.getEmail()+ "  Uname: "+userModel.getName());
//        }




        uname.setText(user.get(loginID).getName());
        email.setText(user.get(loginID).getEmail());
        phone.setText(user.get(loginID).getPhone());


        logout = view.findViewById(R.id.Profile_logout_btn);

        logout.setOnClickListener((e)->{
            Intent logoutIntent = new Intent(view.getContext(), LandingActivity.class);
            startActivity(logoutIntent);
        });

        return view;

    }
}