package com.example.mcsuts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mcsuts.adapter.MatchAdapter;
import com.example.mcsuts.adapter.TransAdapter;
import com.example.mcsuts.model.MatchModel;
import com.example.mcsuts.model.TransactionModel;

import java.util.ArrayList;

public class TransFragment extends Fragment {

    RecyclerView recyclerView;
    TransAdapter transAdapter;
    RecyclerView.LayoutManager layoutManager;

    static ArrayList<TransactionModel> transModels = MatchDetailActivity.transactionModels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_trans, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.trans_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());




        transAdapter = new TransAdapter(transModels);
        recyclerView.setAdapter(transAdapter);
        recyclerView.setLayoutManager(layoutManager);


        return  view;
    }
}