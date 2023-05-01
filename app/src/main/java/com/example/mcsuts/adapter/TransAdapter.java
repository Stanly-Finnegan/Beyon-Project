package com.example.mcsuts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcsuts.R;
import com.example.mcsuts.TransFragment;
import com.example.mcsuts.model.TransactionModel;

import java.util.ArrayList;

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.ViewHolder> {

    private ArrayList<TransactionModel> transactionModels;

    public TransAdapter (ArrayList<TransactionModel> transactionModels){
        this.transactionModels = transactionModels;
    }


    @NonNull
    @Override
    public TransAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trans_model, parent, false);
        return new TransAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransAdapter.ViewHolder holder, int position) {
        TransactionModel transModel = transactionModels.get(position);

        holder.judul.setText(transModel.getJudul());
        holder.textLeft.setText(transModel.getTextLeft());
        holder.textRight.setText(transModel.getTextRight());
        holder.imgLeft.setImageResource(transModel.getImgLeft());
        holder.imgRight.setImageResource(transModel.getImgRight());
        holder.tanggal.setText(transModel.getTanggal());
        holder.tempat.setText(transModel.getTempat());

    }

    @Override
    public int getItemCount() {
        return transactionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul, textLeft, textRight, tanggal, tempat;

        ImageView imgLeft, imgRight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul=itemView.findViewById(R.id.trans_judul);
            textLeft = itemView.findViewById(R.id.trans_text_left);
            textRight = itemView.findViewById(R.id.trans_text_right);
            tanggal = itemView.findViewById(R.id.trans_tanggal);
            imgLeft = itemView.findViewById(R.id.trans_img_left);
            imgRight = itemView.findViewById(R.id.trans_img_right);
            tempat = itemView.findViewById(R.id.trans_tempat);
        }
    }
}
