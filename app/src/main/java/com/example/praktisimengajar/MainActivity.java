package com.example.praktisimengajar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.intent.CareerActivity;
import com.example.praktisimengajar.lifecycle.LifecycleActivity;
import com.example.praktisimengajar.network.NetworkActivity;
import com.example.praktisimengajar.recyclerView.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnIntent = findViewById(R.id.btn_intent);
        btnIntent.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), CareerActivity.class))
        );

        Button btnLifecycle = findViewById(R.id.btn_lifecycle);
        btnLifecycle.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), LifecycleActivity.class))
        );

        Button btnRecyclerView = findViewById(R.id.btn_recyclerview);
        btnRecyclerView.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RecyclerViewActivity.class))
        );

        Button btnRetrofit = findViewById(R.id.btn_retrofit);
        btnRetrofit.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), NetworkActivity.class))
        );
    }
}