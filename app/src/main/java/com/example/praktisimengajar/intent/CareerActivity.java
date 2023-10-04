package com.example.praktisimengajar.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.praktisimengajar.R;


public class CareerActivity extends AppCompatActivity implements View.OnClickListener {

    static String result1 = "Result1";

    TextView tvResult;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent != null) {
                            String data = intent.getStringExtra(result1);
                            String wording = getString(R.string.result_ok, data);
                            tvResult.setText(wording);
                        }
                    } else {
                        tvResult.setText(R.string.result_not_ok);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrer);

        Button buttonNavigation = findViewById(R.id.btn_navigation);
        buttonNavigation.setOnClickListener(this);
        Button buttonNavigationData = findViewById(R.id.btn_navigation_data);
        buttonNavigationData.setOnClickListener(this);
        Button buttonNavigationObject = findViewById(R.id.btn_navigation_object);
        buttonNavigationObject.setOnClickListener(this);
        Button buttonNavigationResult = findViewById(R.id.btn_navigation_result);
        buttonNavigationResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

        Button buttonSend = findViewById(R.id.btn_action_send);
        buttonSend.setOnClickListener(this);
        Button buttonView = findViewById(R.id.btn_action_view);
        buttonView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_navigation) {
            Intent intent = new Intent(this, DetailCareerActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btn_navigation_data) {
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
            Intent intent = new Intent(this, DetailCareerActivity.class);
            mStartForResult.launch(intent);
        } else if (view.getId() == R.id.btn_action_send) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "Hallo saya share ke sosial media");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share to :"));
        } else if (view.getId() == R.id.btn_action_view) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://www.yukngoding.id/me/img/pp.jpg";
            intent.setDataAndType(Uri.parse(url), "image/*");
            startActivity(Intent.createChooser(intent, "View with :"));
        }
    }
}