package com.example.NewsApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class topStoriesAdapter extends RecyclerView.Adapter<topStoriesAdapter.topStoriesViewHolder>{
    private List<News> newsList;
    private Context context;

    public topStoriesAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }
    @NonNull
    @Override
    public topStoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories_row, parent, false);
        return new topStoriesViewHolder(itemView);
    }

    public interface OnRowClickListener {
        void onItemClick (int position);
    }
    public class topStoriesViewHolder extends RecyclerView.ViewHolder {
        public ImageView topStoriesImageView;
        public OnRowClickListener onRowClickListener;

        public topStoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            topStoriesImageView = itemView.findViewById(R.id.topStoriesImageView);
            this.onRowClickListener = onRowClickListener;
        }

    }
    @Override
    public void onBindViewHolder(@NonNull topStoriesViewHolder holder, int position) {
        holder.topStoriesImageView.setImageResource(newsList.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
