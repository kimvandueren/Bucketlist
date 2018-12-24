package com.example.kim.bucketlist;

public class BucketItem {
    private String mBucketTitle;
    private String mBucketDetail;

    public BucketItem(String BucketTitle, String BucketDetail){
        this.mBucketTitle = BucketTitle;
        this.mBucketDetail = BucketDetail;
    }

    public String getmBucketTitle() {
        return mBucketTitle;
    }

    public void setmBucketTitle(String mBucketTitle) {
        this.mBucketTitle = mBucketTitle;
    }

    public String getmBucketDetail() {
        return mBucketDetail;
    }

    public void setmBucketDetail(String mBucketDetail) {
        this.mBucketDetail = mBucketDetail;
    }

}
