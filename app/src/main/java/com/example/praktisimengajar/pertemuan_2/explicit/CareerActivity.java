package com.example.praktisimengajar.pertemuan_2.explicit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.R;


public class CareerActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        Button buttonNavigation = findViewById(R.id.btn_navigation);
        buttonNavigation.setOnClickListener(this);
        Button buttonNavigationPrimitif = findViewById(R.id.btn_navigation_primitif);
        buttonNavigationPrimitif.setOnClickListener(this);
        Button buttonNavigationObject = findViewById(R.id.btn_navigation_object);
        buttonNavigationObject.setOnClickListener(this);
        Button buttonNavigationResult = findViewById(R.id.btn_navigation_result);
        buttonNavigationResult.setOnClickListener(this);

        Button buttonSend = findViewById(R.id.btn_action_send);
        buttonSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_navigation) {
            Intent intent = new Intent(this, DetailCareerActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn_navigation_primitif) {
            Intent intent = new Intent(this, DetailCareerActivity.class);
            intent.putExtra(DetailCareerActivity.param1, "value1");
            startActivity(intent);
        } else if (view.getId() == R.id.btn_navigation_object) {
            Career myCareer = new Career();
            myCareer.id = 1;
            myCareer.name = "Android engineer";

            Intent intent = new Intent(this, DetailCareerActivity.class);
            intent.putExtra(DetailCareerActivity.param2, myCareer);
            startActivity(intent);
        } else if (view.getId() == R.id.btn_navigation_result) {

        } else if (view.getId() == R.id.btn_action_send) {

        }
    }
}