package com.example.praktisimengajar.recyclerView.linear;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    final String[] mDataSet;

    public FoodAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.bindItem(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        String data;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(
                    v1 -> Toast.makeText(v1.getContext(), data, Toast.LENGTH_LONG).show()
            );

            textView = (TextView) v.findViewById(R.id.tv_food);
        }

        public void bindItem(String bindData) {
            data = bindData;
            textView.setText(data);
        }
    }
}