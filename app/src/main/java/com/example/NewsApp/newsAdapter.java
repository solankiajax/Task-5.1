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

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsViewHolder>{
    private List<News> newsList;
    private Context context;
    private OnRowClickListener listener;

    public newsAdapter(List<News> newsList, Context context,OnRowClickListener listener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_row, parent, false);
        return new newsViewHolder(itemView,listener);
    }

    public interface OnRowClickListener {
        void onItemClick (int position,String source);
    }
    public class newsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView newsImageView;
        public TextView newSource,smallDescription;
        public OnRowClickListener onRowClickListener;

        public newsViewHolder(@NonNull View itemView,OnRowClickListener onRowClickListener) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.newsImageView);
            newSource = itemView.findViewById(R.id.newsSource);
            smallDescription = itemView.findViewById(R.id.smallDescription);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onRowClickListener.onItemClick(getAdapterPosition(),this.newSource.getText().toString());
        }
    }
    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getImage());
        holder.newSource.setText(newsList.get(position).getNewsSource());
        holder.smallDescription.setText(newsList.get(position).getSmallDescription());
    }
    @Override
    public int getItemCount() {
        return newsList.size();
    }
}