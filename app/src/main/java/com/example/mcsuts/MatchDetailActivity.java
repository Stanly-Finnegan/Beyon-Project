package com.example.mcsuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcsuts.model.TransactionModel;

import java.util.ArrayList;

public class MatchDetailActivity extends AppCompatActivity {

    TextView capacity, judul, tempat, tanggal, textLeft, textRight;

    ImageView imgTempat, imgLeft, imgRight;

    Button buy;

    String Yjudul;
    String YtextLeft;
    String YtextRight;
    String Ytanggal;
    String Ytempat;
    String Ycapacity;
    int  YimgLeft;
    int YimgRight;
    int YimgTempat;

    static ArrayList<TransactionModel> transactionModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        setTitle("Ticket Order");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        capacity = findViewById(R.id.detail_match_capacity);
        judul = findViewById(R.id.detail_match_judul);
        tempat = findViewById(R.id.detail_match_tempat);
        tanggal = findViewById(R.id.detail_match_tanggal);
        textLeft = findViewById(R.id.detail_match_text_left);
        textRight = findViewById(R.id.detail_match_text_right);
        imgTempat = findViewById(R.id.detail_match_img);
        imgLeft = findViewById(R.id.detail_match_img_left);
        imgRight = findViewById(R.id.detail_match_img_right);
        buy = findViewById(R.id.detail_match_buy_Btn);


        Intent getIntent = getIntent();
        Yjudul = getIntent.getStringExtra("Xjudul");
        YtextLeft = getIntent.getStringExtra("XtextLeft");
        YtextRight = getIntent.getStringExtra("XtextRight");
        Ytanggal = getIntent.getStringExtra("Xtanggal");
        YimgLeft = getIntent.getIntExtra("XimgLeft", 0);
        YimgRight = getIntent.getIntExtra("XimgRight",0);
        Ytempat = getIntent.getStringExtra("Xtempat");
        YimgTempat = getIntent.getIntExtra("XimgTempat",0);
        Ycapacity = getIntent.getStringExtra("Xcapacity");

        capacity.setText(Ycapacity);
        judul.setText(Yjudul);
        tempat.setText(Ytempat);
        tanggal.setText(Ytanggal);
        textLeft.setText(YtextLeft);
        textRight.setText(YtextRight);
        imgTempat.setImageResource(YimgTempat);
        imgLeft.setImageResource(YimgLeft);
        imgRight.setImageResource(YimgRight);


        buy.setOnClickListener((e)->{
            Intent buyIntent = new Intent(this.getBaseContext(),HomeLayoutActivity.class);
            buyIntent.putExtra("bottomNav", 1);
            transactionModels.add(new TransactionModel(
                    Yjudul,
                    YtextLeft,
                    YtextRight,
                    Ytanggal,
                    YimgLeft,
                    YimgRight,
                    Ytempat,
                    YimgTempat,
                    Ycapacity
            ));
            startActivity(buyIntent);
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