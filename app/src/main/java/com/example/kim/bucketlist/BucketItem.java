package com.example.kim.bucketlist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "bucketitem")
public class BucketItem implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "buckettitle")
    private String bucketTitle;
    @ColumnInfo(name = "bucketdetail")
    private String bucketDetail;

    public BucketItem(String bucketTitle, String bucketDetail) {
        this.bucketTitle = bucketTitle;
        this.bucketDetail = bucketDetail;
    }

    protected BucketItem(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        bucketTitle = in.readString();
        bucketDetail = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(bucketTitle);
        dest.writeString(bucketDetail);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBucketTitle() {
        return bucketTitle;
    }

    public void setBucketTitle(String bucketTitle) {
        this.bucketTitle = bucketTitle;
    }

    public String getBucketDetail() {
        return bucketDetail;
    }

    public void setBucketDetail(String bucketDetail) {
        this.bucketDetail = bucketDetail;
    }
}
