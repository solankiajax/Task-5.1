package com.example.NewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class fragmentAdapter extends RecyclerView.Adapter<fragmentAdapter.fragmentViewHolder>{
    private List<News> newsList;
    private Context context;

    public fragmentAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }
    @NonNull
    @Override
    public fragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_stories_row, parent, false);
        return new fragmentViewHolder(itemView);
    }


    public class fragmentViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImageView;
        public TextView newSource, smallDescription;


        public fragmentViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.imageView3);
            newSource = itemView.findViewById(R.id.sources);
            smallDescription = itemView.findViewById(R.id.bigDescription);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull fragmentViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getImage());
        holder.newSource.setText(newsList.get(position).getNewsSource());
        holder.smallDescription.setText(newsList.get(position).getSmallDescription());

    }
    @Override
    public int getItemCount() {
        return newsList.size();
    }
}