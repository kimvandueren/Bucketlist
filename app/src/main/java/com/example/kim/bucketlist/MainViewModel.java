package com.example.kim.bucketlist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class MainViewModel {
    private BucketRepository mRepository;
    private LiveData<List<BucketItem>> mBucketItems;

    public MainViewModel(Context context) {
        mRepository = new BucketRepository(context);
        mBucketItems = mRepository.getAllItems();
    }

    public LiveData<List<BucketItem>> getBucketItems() {
        return mBucketItems;
    }

    public void insert(BucketItem bucketItem) {
        mRepository.insert(bucketItem);
    }

    public void update(BucketItem bucketItem) {
        mRepository.update(bucketItem);
    }

    public void delete(BucketItem bucketItem) {
        mRepository.delete(bucketItem);
    }
}
