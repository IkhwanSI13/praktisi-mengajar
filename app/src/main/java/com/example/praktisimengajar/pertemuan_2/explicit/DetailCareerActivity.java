package com.example.praktisimengajar.pertemuan_2.explicit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.R;

public class DetailCareerActivity extends AppCompatActivity {

    static String param1 = "Param1";
    static String param2 = "Param2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_career);

        /// Code for navigation, navigation with data
        TextView tvData = findViewById(R.id.tv_desc_data);
        String value1 = getIntent().getStringExtra(param1);
        if (value1 != null) {
            tvData.setText(value1);
        } else {
            // textView.setText("Kosong");
            tvData.setText(R.string.empty);
        }

        /// Code for navigation with object
        TextView tvObject = findViewById(R.id.tv_desc_object);
        Career myCareer = (Career) getIntent().getSerializableExtra(param2);
        if (myCareer != null) {
            tvObject.setText("Career id: " + myCareer.id + "\nCareer name: " + myCareer.name);
        } else {
            tvObject.setText(R.string.empty);
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