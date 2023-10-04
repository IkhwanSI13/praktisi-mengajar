package com.example.praktisimengajar.recyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.recyclerView.grid.RvGridActivity;
import com.example.praktisimengajar.recyclerView.gridHorizontal.RvGridHorizontalActivity;
import com.example.praktisimengajar.recyclerView.linear.RvLinearActivity;
import com.example.praktisimengajar.recyclerView.linearHorizontal.RvLinearHorizontalActivity;
import com.example.praktisimengajar.recyclerView.staggered.RvStaggeredActivity;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Button btnLinearVertical = findViewById(R.id.btn_rv_linear_vertical);
        btnLinearVertical.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RvLinearActivity.class))
        );

        Button btnLinearHorizontal = findViewById(R.id.btn_rv_linear_horizontal);
        btnLinearHorizontal.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RvLinearHorizontalActivity.class))
        );

        Button btnGridVertical = findViewById(R.id.btn_rv_grid_vertical);
        btnGridVertical.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RvGridActivity.class))
        );

        Button btnGridHorizontal = findViewById(R.id.btn_rv_grid_horizontal);
        btnGridHorizontal.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RvGridHorizontalActivity.class))
        );

        Button btnStaggered = findViewById(R.id.btn_rv_staggered);
        btnStaggered.setOnClickListener(
                v -> startActivity(new Intent(v.getContext(), RvStaggeredActivity.class))
        );
    }
}