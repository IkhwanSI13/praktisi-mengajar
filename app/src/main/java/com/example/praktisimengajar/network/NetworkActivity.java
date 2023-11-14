package com.example.praktisimengajar.network;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.network.data.PostAdapter;
import com.example.praktisimengajar.network.data.model.Posts;
import com.example.praktisimengajar.network.data.network.ApiClient;
import com.example.praktisimengajar.network.data.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    PostAdapter postAdapter;
    ArrayList<Posts> dataSet = new ArrayList<>();

    ApiInterface api = ApiClient.getInterface();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        recyclerView = findViewById(R.id.rv_posts);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        postAdapter = new PostAdapter(dataSet);

        recyclerView.setAdapter(postAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getData();
    }

    private void getData() {
        api.getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                Log.e("Ikhwan", response.body().get(0).getBody());
                dataSet.addAll(response.body());
//                postAdapter.notifyDataSetChanged();
                postAdapter.notifyItemRangeInserted(0, response.body().size());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(NetworkActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}