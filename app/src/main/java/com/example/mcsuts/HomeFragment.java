package com.example.mcsuts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcsuts.adapter.NewsAdapter;
import com.example.mcsuts.model.NewsModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<NewsModel> newsModels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.news_recycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        if(newsModels.isEmpty()){
            for(int i=0; i<NewsData.judul.length; i++){
                newsModels.add(new NewsModel(
                        NewsData.judul[i],
                        NewsData.tanggal[i],
                        NewsData.detail[i],
                        NewsData.source[i],
                        NewsData.img[i]
                ));
            }
        }


        newsAdapter = new NewsAdapter(newsModels);
        recyclerView.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickCallBack(new NewsAdapter.OnItemClickCallBack() {
            @Override
            public void OnItemClicked(NewsModel newsModel) {
                Intent detailIntent = new Intent(getContext(),NewsDetailActivity.class);
                detailIntent.putExtra("xjudul", newsModel.getJudul());
                detailIntent.putExtra("xtanggal", newsModel.getTanggal());
                detailIntent.putExtra("xdetail", newsModel.getDetail());
                detailIntent.putExtra("xsource", newsModel.getSource());
                detailIntent.putExtra("ximg", newsModel.getImg());
                startActivity(detailIntent);
            }
        });

        return view;
    }
}