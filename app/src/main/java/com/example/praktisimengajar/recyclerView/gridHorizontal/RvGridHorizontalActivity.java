package com.example.praktisimengajar.recyclerView.gridHorizontal;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

public class RvGridHorizontalActivity extends AppCompatActivity implements OnItemClickListener {

    RecyclerView recyclerView;

    SampleAdapter sampleAdapter;
    String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_grid_horizontal);

        recyclerView = findViewById(R.id.rv_food);

        initDataset();
        sampleAdapter = new SampleAdapter(dataSet, this);
//        sampleAdapter = new SampleAdapter(dataSet, new OnItemClickListener() {
//            @Override
//            public void onItemClick() {
//                Log.e("Ikhwan","Log");
//
//            }
//        });

        recyclerView.setAdapter(sampleAdapter);
    }

    private void initDataset() {
        dataSet = new String[50];
        for (int i = 0; i < 50; i++) {
            dataSet[i] = "Element #" + i;
        }
    }

    @Override
    public void onItemClick() {
        Log.e("Ikhwan","Log");
    }
}