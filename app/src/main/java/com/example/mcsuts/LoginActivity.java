package com.example.mcsuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcsuts.helper.UserDatabaseHelper;
import com.example.mcsuts.model.UserModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.Vector;

public class LoginActivity extends AppCompatActivity {

    TextView register;

    TextInputEditText email, pass;

    Button login;

    UserDatabaseHelper dbHelper = new UserDatabaseHelper(this);


    TextInputLayout textInputLayoutEmail, textInputLayoutPass;

    static  List<UserModel> user;

    public static int loginId;

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




        register.setOnClickListener((e) ->{
            Intent regisIntent = new Intent(this.getBaseContext(),RegisterActivity.class);
            startActivity(regisIntent);
        });

        login.setOnClickListener((e)->{
            String tempEmail = email.getText().toString();
            String tempPass = pass.getText().toString();


            if(!TextUtils.isEmpty(tempEmail) || !TextUtils.isEmpty(tempPass)){

                 user = dbHelper.getAllUser();

                for(UserModel userModel: user){
                    if(tempEmail.toLowerCase().equals(userModel.getEmail()) || tempEmail.equals(userModel.getPhone())){
                        if(tempPass.equals(userModel.getPass())){
                            Intent loginIntent = new Intent(this.getBaseContext(), HomeLayoutActivity.class);
                            loginId = userModel.getId();
                            startActivity(loginIntent);
                            return;
                        }
                    }



                }


            }



            textInputLayoutEmail.setHelperText("Check your email or phone number!");
            textInputLayoutPass.setHelperText("Check your password!");



        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}