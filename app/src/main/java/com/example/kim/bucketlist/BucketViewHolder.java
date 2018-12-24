package com.example.kim.bucketlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BucketViewHolder extends RecyclerView.ViewHolder {
    public TextView bucketTitle;
    public TextView bucketDetail;
    public View view;

    public BucketViewHolder(View itemView) {
        super(itemView);
        bucketTitle = itemView.findViewById(R.id.bucketTitle);
        bucketDetail = itemView.findViewById(R.id.bucketDetail);
        view = itemView;
    }
}
