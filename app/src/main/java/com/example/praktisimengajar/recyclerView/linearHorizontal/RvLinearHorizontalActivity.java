package com.example.praktisimengajar.recyclerView.linearHorizontal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

public class RvLinearHorizontalActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FoodHorizontalAdapter foodHorizontalAdapter;
    String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_linear_horizontal);

        recyclerView = findViewById(R.id.rv_food);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
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