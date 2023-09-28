package com.example.praktisimengajar.pertemuan_2.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.R;

public class LifecycleActivity extends AppCompatActivity {

    static String KEY_COUNT = "count";

    TextView tvCount;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.e(LifecycleActivity.class.getName(), "onCreate");

        tvCount = findViewById(R.id.tv_count);
        tvCount.setText(String.valueOf(count));

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(v -> {
            count++;
            tvCount.setText(String.valueOf(count));
        });

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0);
            tvCount.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LifecycleActivity.class.getName(), "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LifecycleActivity.class.getName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LifecycleActivity.class.getName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LifecycleActivity.class.getName(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LifecycleActivity.class.getName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LifecycleActivity.class.getName(), "onDestroy");
    }

    // Save State
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }

//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        count = savedInstanceState.getInt(KEY_COUNT, 0);
//        tvCount.setText(String.valueOf(count));
//    }

}