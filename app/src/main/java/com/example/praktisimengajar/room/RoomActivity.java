package com.example.praktisimengajar.room;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.room.data.local.AppDatabase;
import com.example.praktisimengajar.room.data.local.Food;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity implements FoodClickListener, ExecutorCallback {
    /// Room
    AppDatabase appDatabase;
    ExecutorCallback executorCallback;

    /// View
    EditText etName;
    EditText etPrice;
    Button btnSave;

    /// RecyclerView
    RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    ArrayList<Food> dataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        appDatabase = AppDatabase.getDatabase(getApplication());
        executorCallback = this;

        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        btnSave = findViewById(R.id.btn_save);
        recyclerView = findViewById(R.id.rv_foods);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        foodAdapter = new FoodAdapter(dataSet, this);
        recyclerView.setAdapter(foodAdapter);

        btnSave.setOnClickListener(v -> {
            /// Hide keyboard
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            /// Insert case
            String name = etName.getText().toString();
            String price = etPrice.getText().toString();

            Food newFood = new Food();
            newFood.name = name;
            newFood.price = price;

            insertFood(newFood);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        getData();
    }

    @Override
    public void onClick(Food food) {
        Toast.makeText(this, food.name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickDelete(Food food) {
        deleteFood(food);
    }

    @Override
    public void onComplete(List<Food> result) {
        dataSet.clear();
        dataSet.addAll(result);

        foodAdapter.notifyDataSetChanged();
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    private void getData() {
        AppDatabase.databaseWriteExecutor.submit(() -> {
            List<Food> foods = appDatabase.foodDao().getAll();
            executorCallback.onComplete(foods);
        });
    }

    private void insertFood(Food newFood) {
        AppDatabase.databaseWriteExecutor.submit(() -> {
            appDatabase.foodDao().insert(newFood);

            List<Food> foods = appDatabase.foodDao().getAll();
            executorCallback.onComplete(foods);
        });
    }

    private void deleteFood(Food food) {
        AppDatabase.databaseWriteExecutor.submit(() -> {
            appDatabase.foodDao().delete(food);

            List<Food> foods = appDatabase.foodDao().getAll();
            executorCallback.onComplete(foods);
        });
    }
}