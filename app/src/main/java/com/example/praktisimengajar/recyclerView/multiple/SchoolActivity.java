package com.example.praktisimengajar.recyclerView.multiple;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.recyclerView.multiple.model.School;
import com.example.praktisimengajar.recyclerView.multiple.model.University;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    SchoolAdapter schoolAdapter;
    List<Object> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        recyclerView = findViewById(R.id.rv_school);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        initDataset();
        schoolAdapter = new SchoolAdapter(dataSet);

        recyclerView.setAdapter(schoolAdapter);
    }

    private void initDataset() {
        dataSet = new ArrayList<>();
        dataSet.add(new School(1, "SMA Negeri 1 Padang", "Gedung lama SMA 1, Jl. Belanti Raya, Lolong Belanti, Kec. Padang Utara, Kota Padang"));
        dataSet.add(new School(2, "SMA Negeri 1 Ampek Angkek", "Lambah, Ampek Angkek, Agam Regency"));
        dataSet.add(new University(3, "Universitas Andalas", 44));
        dataSet.add(new School(4, "SMA Negeri 1 Bukittinggi", "Jl. Syekh Jamil Jambek No.36, Pakan Kurai, Kec. Guguk Panjang, Kota Bukittinggi"));
        dataSet.add(new University(5, "Universitas Negeri Padang", 54));
    }
}