package com.example.kim.bucketlist;

import android.os.Parcel;
import android.os.Parcelable;

public class BucketItem implements Parcelable {
    private String mBucketTitle;
    private String mBucketDetail;

    public BucketItem(String BucketTitle, String BucketDetail){
        this.mBucketTitle = BucketTitle;
        this.mBucketDetail = BucketDetail;
    }

    protected BucketItem(Parcel in) {
        mBucketTitle = in.readString();
        mBucketDetail = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBucketTitle);
        dest.writeString(this.mBucketDetail);
    }

    public static final Creator<BucketItem> CREATOR = new Creator<BucketItem>() {
        @Override
        public BucketItem createFromParcel(Parcel in) {
            return new BucketItem(in);
        }

        @Override
        public BucketItem[] newArray(int size) {
            return new BucketItem[size];
        }
    };
}
