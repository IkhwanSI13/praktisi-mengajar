package com.example.praktisimengajar.pertemuan_2.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.praktisimengajar.R;

public class DetailCareerActivity extends AppCompatActivity {

    static String param1 = "Param1";
    static String param2 = "Param2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_career);

        TextView textViewPrimitive = findViewById(R.id.tv_desc_primitive);
        TextView textViewObject = findViewById(R.id.tv_desc_object);

        // btn_navigation, btn_navigation_primitif
        String value1 = getIntent().getStringExtra(param1);
        if (value1 != null) {
            textViewPrimitive.setText(value1);
        } else {
            // textView.setText("Kosong");
            textViewPrimitive.setText(R.string.empty);
        }

        Career myCareer = (Career) getIntent().getSerializableExtra(param2);
        if (myCareer != null) {
            Log.e("Ikhwan","myCareer != null");
            textViewObject.setText("Career id: " + myCareer.id + "\nCareer name: " + myCareer.name);
        } else {
            Log.e("Ikhwan","myCareer == null");
            textViewObject.setText(R.string.empty);
        }
    }
}