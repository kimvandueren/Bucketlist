package com.example.kim.bucketlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BucketDao {
    @Query("SELECT * FROM bucketitem")
    public LiveData<List<BucketItem>> getAllItems();

    @Insert
    public void insertItem(BucketItem bucketItem);

    @Delete
    public void deleteItem(BucketItem bucketItem);

    @Update
    public void updateItem(BucketItem bucketItem);
}
