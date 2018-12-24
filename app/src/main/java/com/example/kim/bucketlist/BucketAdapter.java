package com.example.kim.bucketlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BucketAdapter extends RecyclerView.Adapter<BucketViewHolder> {
    private Context context;
    public List<BucketItem> listBucketItem;

    public BucketAdapter(Context context, List<BucketItem> listBucketItem){
        this.context = context;
        this.listBucketItem = listBucketItem;
    }

    @NonNull
    @Override
    public BucketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell, viewGroup, false);
        return new BucketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketViewHolder holder, int i) {
        final BucketItem bucketItem = listBucketItem.get(i);
        holder.bucketTitle.setText(bucketItem.getmBucketTitle());
        holder.bucketDetail.setText(bucketItem.getmBucketDetail());
    }

    @Override
    public int getItemCount() {
        return listBucketItem.size();
    }
}
