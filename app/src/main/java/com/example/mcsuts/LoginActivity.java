package com.example.mcsuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcsuts.adapter.DatabaseAdapter;
import com.example.mcsuts.model.UserModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Vector;

public class LoginActivity extends AppCompatActivity {

    TextView register;

    TextInputEditText email, pass, phone;

    Button login;

    private DatabaseAdapter dbAdapter;


    TextInputLayout textInputLayoutEmail, textInputLayoutPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.Login_Email_Edtx);
        pass = findViewById(R.id.Login_Pass_Edtx);
        register = findViewById(R.id.Login_Register_Btn);
        login = findViewById(R.id.Login_login_Btn);
        textInputLayoutEmail = findViewById(R.id.Login_Email_Edtx_layout);
        textInputLayoutPass = findViewById(R.id.Login_Pass_Edtx_layout);


        Intent getIntent = getIntent();
        int id = getIntent.getIntExtra("idcount",0);


        register.setOnClickListener((e) ->{
            Intent regisIntent = new Intent(this.getBaseContext(),RegisterActivity.class);
            startActivity(regisIntent);
        });

        login.setOnClickListener((e)->{
            String tempEmail = email.getText().toString();
            String tempPass = pass.getText().toString();

            if(!TextUtils.isEmpty(tempEmail) || !TextUtils.isEmpty(tempPass)){

                Vector<UserModel> user = dbAdapter.getUserData();

                for(int i=0; i<id; i++){
                    if(tempEmail.equals(user.get(1).getEmail()) || tempEmail.equals(user.get(1).getPhone())){
                        Intent loginIntent = new Intent(this.getBaseContext(), HomeLayoutActivity.class);
                        startActivity(loginIntent);
                        return;
                    }
                }

            }





            Toast.makeText(this, "A"+id, Toast.LENGTH_SHORT).show();


            textInputLayoutEmail.setHelperText("Check your email or phone number!");
            textInputLayoutPass.setHelperText("Check your password!");



        });

    }


}