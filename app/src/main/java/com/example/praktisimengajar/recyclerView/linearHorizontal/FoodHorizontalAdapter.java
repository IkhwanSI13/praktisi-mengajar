package com.example.praktisimengajar.recyclerView.linearHorizontal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

public class FoodHorizontalAdapter extends RecyclerView.Adapter<FoodHorizontalAdapter.ViewHolder> {

    final String[] mDataSet;

    public FoodHorizontalAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public FoodHorizontalAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_horizontal_item, viewGroup, false);

        return new FoodHorizontalAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FoodHorizontalAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.bindItem(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textView;
        String data;

        public ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.iv_food);
            imageView.setOnClickListener(
                    v12 -> Toast.makeText(v12.getContext(), data, Toast.LENGTH_LONG).show()
            );

            textView = v.findViewById(R.id.tv_food);
        }

        public void bindItem(String bindData) {
            data = bindData;
            textView.setText(data);
        }
    }
}