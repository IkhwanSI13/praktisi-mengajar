package com.example.praktisimengajar.recyclerView.linear;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

public class RvLinearActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    FoodAdapter foodAdapter;
    String[] dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_linear);

        recyclerView = findViewById(R.id.rv_food);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        initDataset();
        foodAdapter = new FoodAdapter(dataSet);

        recyclerView.setAdapter(foodAdapter);
    }

    private void initDataset() {
        dataSet = new String[50];
        for (int i = 0; i < 50; i++) {
            dataSet[i] = "This is element #" + i;
        }
    }
}