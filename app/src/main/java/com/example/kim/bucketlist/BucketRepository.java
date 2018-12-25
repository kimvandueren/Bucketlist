package com.example.kim.bucketlist;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BucketRepository {
    private AppDatabase mAppDatabase;
    private BucketDao mBucketDao;
    private LiveData<List<BucketItem>> mBucketItems;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public BucketRepository (Context context) {
        mAppDatabase = AppDatabase.getInstance(context);
        mBucketDao = mAppDatabase.bucketDao();
        mBucketItems= mBucketDao.getAllItems();
    }

    public LiveData<List<BucketItem>> getAllItems() {
        return mBucketItems;
    }

    public void insert(final BucketItem bucketItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.insertItem(bucketItem);
            }
        });
    }

    public void update(final BucketItem bucketItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.updateItem(bucketItem);
            }
        });
    }

    public void delete(final BucketItem bucketItem) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mBucketDao.deleteItem(bucketItem);
            }
        });
    }
}
