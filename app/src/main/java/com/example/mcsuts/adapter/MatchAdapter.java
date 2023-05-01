package com.example.mcsuts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcsuts.R;
import com.example.mcsuts.model.MatchModel;

import java.util.ArrayList;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {


    private static ArrayList<MatchModel> matchModels;

    public MatchAdapter (ArrayList<MatchModel> matchModels){
        this.matchModels = matchModels;
    }

    public interface OnItemClickCallBack{
        void onItemClicked(MatchModel matchModel);
    }

    private OnItemClickCallBack callback;

    public void setOnItemClickCallBack(OnItemClickCallBack callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public MatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_model, parent, false);
        return new MatchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.ViewHolder holder, int position) {
        MatchModel matchModel = matchModels.get(position);

        holder.judul.setText(matchModel.getJudul());
        holder.textLeft.setText(matchModel.getTextLeft());
        holder.textRight.setText(matchModel.getTextRight());
        holder.imgLeft.setImageResource(matchModel.getImgLeft());
        holder.imgRight.setImageResource(matchModel.getImgRight());
        holder.tanggal.setText(matchModel.getTanggal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClicked(matchModels.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return matchModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul, textLeft, textRight, tanggal;

        ImageView imgLeft, imgRight;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul=itemView.findViewById(R.id.match_judul);
            textLeft = itemView.findViewById(R.id.match_text_left);
            textRight = itemView.findViewById(R.id.match_text_right);
            tanggal = itemView.findViewById(R.id.match_tanggal);
            imgLeft = itemView.findViewById(R.id.match_img_left);
            imgRight = itemView.findViewById(R.id.match_img_right);
        }
    }
}
