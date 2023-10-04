package com.example.praktisimengajar.recyclerView.grid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.recyclerView.linearHorizontal.FoodHorizontalAdapter;

public class RvGridActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FoodHorizontalAdapter foodHorizontalAdapter;
    String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_grid);

        recyclerView = findViewById(R.id.rv_food);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        // Custom spanSize
//        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 1 || position == 4) return 2;
//                return 1;
//            }
//        });

        recyclerView.setLayoutManager(mLayoutManager);

        initDataset();
        foodHorizontalAdapter = new FoodHorizontalAdapter(dataSet);

        recyclerView.setAdapter(foodHorizontalAdapter);
    }

    private void initDataset() {
        dataSet = new String[50];
        for (int i = 0; i < 50; i++) {
            dataSet[i] = "Element #" + i;
        }
    }
}