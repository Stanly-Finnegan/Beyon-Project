package com.example.mcsuts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcsuts.adapter.DatabaseAdapter;


public class RegisterActivity extends AppCompatActivity {

    EditText uname, email, pass, phone;
    Button register;

    public int count;

    private DatabaseAdapter dbAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        register = findViewById(R.id.Register_Register_Btn);
        uname = findViewById(R.id.Register_Uname_Edtx);
        email = findViewById(R.id.Register_Email_Edtx);
        pass = findViewById(R.id.Register_Pass_Edtx);
        phone = findViewById(R.id.Register_Phone_Edtx);

        Context context = getApplicationContext();

        setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        register.setOnClickListener((e) -> {


            dbAdapter.insertUserData("aten", "dummy@gmail.com", "1234567890", "Aa1");


            count = 0;
            //            Uname Condition !!!
            String tempUname = uname.getText().toString();
            if(TextUtils.isEmpty(tempUname)){
                uname.setError("This field cannot be empty");
                count = -1;
            }
            else if(!tempUname.matches("[a-z A-Z]+")){
                uname.setError("This field can only contain alphabetical!");
                count = -1;
            }
//            -- End Uname --

//            Email Condition !!!
            String tempEmail = email.getText().toString();
            if(TextUtils.isEmpty(tempEmail)){
                email.setError("This field cannot be empty");
                count = -1;
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(tempEmail).matches()) {
                email.setError("Invalid email address!");
                count = -1;
            }
//            -- End Email --

//            Phone Condition !!!
            String tempPhone = phone.getText().toString();
            if(TextUtils.isEmpty(tempPhone)){
                phone.setError("This field cannot be empty");
                count = -1;
            }
            else if (!Patterns.PHONE.matcher(tempPhone).matches() || tempPhone.length() < 10 || tempPhone.length() > 13) {
                phone.setError("Invalid phone number!");
                count = -1;
            }
//            -- End Phone --

//            Pass Condition !!!
            String tempPass = pass.getText().toString();
            if(TextUtils.isEmpty(tempPass)){
                pass.setError("This field cannot be empty");
                count = -1;
            } else if (!tempPass.matches(".*[A-Z].*")) {
                pass.setError("Must contains minimum 1 Upper-case Character!");
                count = -1;
            } else if (!tempPass.matches(".*[a-z].*")) {
                pass.setError("Must contains minimum 1 Lower-case Character!");
                count = -1;
            } else if (!tempPass.matches(".*[0-9].*")) {
                pass.setError("Must contains minimum 1 number!");
                pass.requestFocus();

                count = -1;
            }
//            -- End Pass --

            Log.i("name", tempUname);

            if(count != 0){
                return;
            }



                Intent regisIntent = new Intent(this.getBaseContext(), LandingActivity.class);
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
                startActivity(regisIntent);

        });

    }
}