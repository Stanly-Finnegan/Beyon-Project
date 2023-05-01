package com.example.mcsuts.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcsuts.R;
import com.example.mcsuts.model.NewsModel;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{


    ArrayList<NewsModel> newsModels ;


    public NewsAdapter (ArrayList<NewsModel> newsModels){
        this.newsModels = newsModels;
    }

   public interface OnItemClickCallBack{
        void OnItemClicked(NewsModel newsModel);
   }


    private OnItemClickCallBack callBack;

    public void setOnItemClickCallBack(OnItemClickCallBack callBack){
        this.callBack = callBack;
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_model, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        NewsModel newsModel = newsModels.get(position);

        holder.judul.setText(newsModel.getJudul());
        holder.tanggal.setText(newsModel.getTanggal());
        holder.image.setImageResource(newsModel.getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.OnItemClicked(newsModels.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView judul, tanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.news_image);
            judul = itemView.findViewById(R.id.news_judul);
            tanggal = itemView.findViewById(R.id.news_tanggal);
        }
    }
}
