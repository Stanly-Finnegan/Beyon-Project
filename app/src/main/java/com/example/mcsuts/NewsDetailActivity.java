package com.example.mcsuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcsuts.adapter.NewsAdapter;
import com.example.mcsuts.model.NewsModel;

import java.util.ArrayList;

public class NewsDetailActivity extends AppCompatActivity {



    TextView judul, tanggal, source, text;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);


        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        judul = findViewById(R.id.news_detail_judul);
        tanggal = findViewById(R.id.news_detail_tanggal);
        source = findViewById(R.id.news_detail_source);
        text = findViewById(R.id.news_detail_text);
        img = findViewById(R.id.news_detail_img);

        Intent getIntent = getIntent();
        String yjudul = getIntent.getStringExtra("xjudul");
        String ytanggal = getIntent.getStringExtra("xtanggal");
        String ydetail = getIntent.getStringExtra("xdetail");
        String ysource = getIntent.getStringExtra("xsource");
        int yimg = getIntent.getIntExtra("ximg",0);


        judul.setText(yjudul);
        tanggal.setText(ytanggal);
        text.setText(ydetail);
        source.setText(ysource);
        img.setImageResource(yimg);




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