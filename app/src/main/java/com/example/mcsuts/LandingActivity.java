package com.example.mcsuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcsuts.adapter.DatabaseAdapter;

public class LandingActivity extends AppCompatActivity {
    Button Landing_Login_btn, Landing_Register_btn;
    TextView Landing_Regis_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

//        Hilangin Action Bar
        getSupportActionBar().hide();
//        End



//        Cari Id
        Landing_Login_btn = findViewById(R.id.Landing_login_Btn);
        Landing_Regis_btn = findViewById(R.id.Landing_Register_Btn);
//        End Cari Id

        Intent getIntent = getIntent();
        int id = getIntent.getIntExtra("idcount", 0);



//        Onclick Button
        Landing_Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(v.getContext(), LoginActivity.class);
                loginIntent.putExtra("idcount", id);
                startActivity(loginIntent);
            }
        });


        Landing_Regis_btn.setOnClickListener((e) ->{
            Intent regisIntent = new Intent(this.getBaseContext(),RegisterActivity.class);
            startActivity(regisIntent);
        });

//        End Onclick Button

    }
}