package com.example.kim.bucketlist;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<BucketItem> bucketItems = new ArrayList<>();
    private BucketAdapter bucketAdapter;
    private RecyclerView recyclerView;
    private MainViewModel mMainViewModel;

    //Constants used when calling the 'AddItem' activity
    public static final String NEW_ITEM = "Item";
    public static final int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        mMainViewModel = new MainViewModel(getApplicationContext());
        mMainViewModel.getBucketItems().observe(this, new Observer<List<BucketItem>>() {
            @Override
            public void onChanged(@Nullable List<BucketItem> bucket) {
                bucketItems = bucket;
                updateUI();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }
                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        mMainViewModel.delete(bucketItems.get(position));
                        bucketItems.remove(position);
                        bucketAdapter.notifyItemRemoved(position);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void updateUI() {
        if (bucketAdapter == null) {
            bucketAdapter = new BucketAdapter(this, bucketItems);
            recyclerView.setAdapter(bucketAdapter);
        } else {
            bucketAdapter.swapList(bucketItems);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUESTCODE){
            if (resultCode == RESULT_OK){
                BucketItem addedItem = data.getParcelableExtra(MainActivity.NEW_ITEM);
                bucketItems.add(addedItem);
                mMainViewModel.insert(addedItem);
                updateUI();
            }
        }
    }
}
