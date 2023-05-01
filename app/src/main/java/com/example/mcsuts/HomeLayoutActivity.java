package com.example.mcsuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeLayoutActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ProfileFragment profileFragment = new ProfileFragment();
    TransFragment transFragment = new TransFragment();
    MatchFragment matchFragment = new MatchFragment();
    HomeFragment homeFragment = new HomeFragment();

    Integer loginID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        getSupportActionBar().hide();

        Intent getIntent = getIntent();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        int bNav  = getIntent.getIntExtra("bottomNav", 0);
         if(bNav == 1){
             getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, transFragment).commit();
         }
         else {
             getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commit();
         }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeMenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commit();
                        return true;
                    case R.id.matchMenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, matchFragment).commit();
                        return true;
                    case  R.id.transMenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, transFragment).commit();
                        return true;
                    case R.id.profileMenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });

    }
}