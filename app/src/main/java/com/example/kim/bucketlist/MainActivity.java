package com.example.kim.bucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<BucketItem> bucketItems = new ArrayList<>();
    private BucketAdapter bucketAdapter;
    private RecyclerView recyclerView;

    //Constants used when calling the 'AddItem' activity
    public static final String NEW_ITEM = "Item";
    public static final int REQUESTCODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bucketItems.add(new BucketItem("titelvoorbeeld", "details"));
        bucketItems.add(new BucketItem("test", "testde"));

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        updateUI();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    private void updateUI() {
        if (bucketAdapter == null) {
            bucketAdapter = new BucketAdapter(this, bucketItems);
            recyclerView.setAdapter(bucketAdapter);
        } else {
            bucketAdapter.notifyDataSetChanged();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUESTCODE){
            if (resultCode == RESULT_OK){
                BucketItem addedItem = data.getParcelableExtra(MainActivity.NEW_ITEM);
                bucketItems.add(addedItem);
                updateUI();
            }
        }
    }
}
