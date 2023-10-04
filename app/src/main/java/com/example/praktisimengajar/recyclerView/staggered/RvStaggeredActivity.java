package com.example.praktisimengajar.recyclerView.staggered;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.recyclerView.linearHorizontal.FoodHorizontalAdapter;

public class RvStaggeredActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FoodHorizontalAdapter foodHorizontalAdapter;
    String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_staggered);

        recyclerView = findViewById(R.id.rv_food);

        StaggeredGridLayoutManager mLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);

        initDataset();
        foodHorizontalAdapter = new FoodHorizontalAdapter(dataSet);

        recyclerView.setAdapter(foodHorizontalAdapter);
    }

    private void initDataset() {
        dataSet = new String[50];
        for (int i = 0; i < 50; i++) {
            if (i == 3 || i == 6) {
                dataSet[i] = "Lorem ipsum dolor ipsum dolor ipsum dolor ipsum dolor #" + i;
            } else {
                dataSet[i] = "Element #" + i;
            }
        }
    }
}