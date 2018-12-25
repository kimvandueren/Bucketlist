package com.example.kim.bucketlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {
    public static BucketItem bucketItem;
    private EditText titleText;
    private EditText detailText;
    private Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        setTitle("Add an item");

        titleText = findViewById(R.id.titleEdit);
        detailText = findViewById(R.id.detailEdit);
        button = findViewById(R.id.saveButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                bucketItem = new BucketItem(titleText.getText().toString(),
                        detailText.getText().toString()
                );
                intent.putExtra(MainActivity.NEW_ITEM, bucketItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
