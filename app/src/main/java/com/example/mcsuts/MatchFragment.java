package com.example.mcsuts;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcsuts.adapter.MatchAdapter;
import com.example.mcsuts.model.MatchModel;
import com.example.mcsuts.model.TransactionModel;

import java.util.ArrayList;


public class MatchFragment extends Fragment {

    RecyclerView recyclerView;
    MatchAdapter matchAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<MatchModel> matchModels = new ArrayList<>();

    static  ArrayList<TransactionModel> transactionModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.match_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());


       if(matchModels.isEmpty()){
           for (int i=0; i< MatchData.judul.length; i++){
               matchModels.add(new MatchModel(
                       MatchData.judul[i],
                       MatchData.textleft[i],
                       MatchData.textright[i],
                       MatchData.tanggal[i],
                       MatchData.imgleft[i],
                       MatchData.imgright[i],
                       MatchData.tempat[i],
                       MatchData.imgtempat[i],
                       MatchData.capacity[i]
               ));
           }
       }



        matchAdapter = new MatchAdapter(matchModels);
        recyclerView.setAdapter(matchAdapter);
        recyclerView.setLayoutManager(layoutManager);

        matchAdapter.setOnItemClickCallBack(new MatchAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(MatchModel matchModel) {
                Intent transactionIntent = new Intent(view.getContext(), MatchDetailActivity.class);
                transactionIntent.putExtra("Xjudul", matchModel.getJudul());
                transactionIntent.putExtra("XtextLeft", matchModel.getTextLeft());
                transactionIntent.putExtra("XtextRight", matchModel.getTextRight());
                transactionIntent.putExtra("Xtanggal", matchModel.getTanggal());
                transactionIntent.putExtra("XimgLeft", matchModel.getImgLeft());
                transactionIntent.putExtra("XimgRight", matchModel.getImgRight());
                transactionIntent.putExtra("Xtempat", matchModel.getTempat());
                transactionIntent.putExtra("XimgTempat", matchModel.getImgTempat());
                transactionIntent.putExtra("Xcapacity", matchModel.getCapacity());

                startActivity(transactionIntent);
            }
        });


        return view;
    }
}