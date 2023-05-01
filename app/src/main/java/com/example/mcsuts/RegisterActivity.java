package com.example.mcsuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcsuts.helper.UserDatabaseHelper;


public class RegisterActivity extends AppCompatActivity {

    EditText uname, email, pass, phone;
    Button register;

    public int count;

    private UserDatabaseHelper dbHelper = new UserDatabaseHelper(this);

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





            count = 0;
            //            Uname Condition !!!
            String tempUname = uname.getText().toString();
            if(TextUtils.isEmpty(tempUname)){
                uname.setError("This field cannot be empty");
                uname.requestFocus();
                count = -1;
            }
            else if(!tempUname.matches("[a-z A-Z]+")){
                uname.setError("This field can only contain alphabetical!");
                uname.requestFocus();
                count = -1;
            }
//            -- End Uname --

//            Email Condition !!!
            String tempEmail = email.getText().toString();
            if(TextUtils.isEmpty(tempEmail)){
                email.setError("This field cannot be empty");
                email.requestFocus();
                count = -1;
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(tempEmail).matches()) {
                email.setError("Invalid email address!");
                email.requestFocus();
                count = -1;
            }
//            -- End Email --

//            Phone Condition !!!
            String tempPhone = phone.getText().toString();
            if(TextUtils.isEmpty(tempPhone)){
                phone.setError("This field cannot be empty");
                phone.requestFocus();
                count = -1;
            }
            else if (!Patterns.PHONE.matcher(tempPhone).matches() || tempPhone.length() < 10 || tempPhone.length() > 13) {
                phone.setError("Invalid phone number!");
                phone.requestFocus();
                count = -1;
            }
//            -- End Phone --

//            Pass Condition !!!
            String tempPass = pass.getText().toString();
            if(TextUtils.isEmpty(tempPass)){
                pass.setError("This field cannot be empty");
                pass.requestFocus();
                count = -1;
            } else if (!tempPass.matches(".*[A-Z].*")) {
                pass.setError("Must contains minimum 1 Upper-case Character!");
                pass.requestFocus();
                count = -1;
            } else if (!tempPass.matches(".*[a-z].*")) {
                pass.setError("Must contains minimum 1 Lower-case Character!");
                pass.requestFocus();
                count = -1;
            } else if (!tempPass.matches(".*[0-9].*")) {
                pass.setError("Must contains minimum 1 number!");
                pass.requestFocus();

                count = -1;
            }
//            -- End Pass --



            if(count != 0){
                return;
            }


                dbHelper.insertUser(tempUname, tempEmail.toLowerCase(), tempPhone, tempPass);

                Intent regisIntent = new Intent(this.getBaseContext(), LandingActivity.class);
                startActivity(regisIntent);

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