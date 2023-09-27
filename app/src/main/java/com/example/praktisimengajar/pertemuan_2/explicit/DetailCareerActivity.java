package com.example.praktisimengajar.pertemuan_2.explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.praktisimengajar.R;

public class DetailCareerActivity extends AppCompatActivity {

    static String param1 = "Param1";
    static String param2 = "Param2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_career);

        /// Code for navigation, navigation with primitive data
        TextView textViewPrimitive = findViewById(R.id.tv_desc_primitive);
        String value1 = getIntent().getStringExtra(param1);
        if (value1 != null) {
            textViewPrimitive.setText(value1);
        } else {
            // textView.setText("Kosong");
            textViewPrimitive.setText(R.string.empty);
        }

        /// Code for navigation with object
        TextView textViewObject = findViewById(R.id.tv_desc_object);
        Career myCareer = (Career) getIntent().getSerializableExtra(param2);
        if (myCareer != null) {
            textViewObject.setText("Career id: " + myCareer.id + "\nCareer name: " + myCareer.name);
        } else {
            textViewObject.setText(R.string.empty);
        }

        /// Code for navigation with result for previous activity
        Button btnSendResult = findViewById(R.id.btn_desc_waiting_for_result);
        btnSendResult.setOnClickListener(v -> {
            Intent intent = new Intent();
            // intent.putExtra("Result1", "hasil loh ini");
            intent.putExtra(CareerActivity.result1, "hasil loh ini");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}