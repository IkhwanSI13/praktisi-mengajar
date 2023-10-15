package com.example.praktisimengajar.recyclerView.gridHorizontal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    final String[] mDataSet;
    final OnItemClickListener mItemClickListener;

    public SampleAdapter(String[] dataSet, OnItemClickListener itemClickListener) {
        mDataSet = dataSet;
        mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public SampleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_horizontal_item, viewGroup, false);

        return new SampleAdapter.ViewHolder(v, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(SampleAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.bindItem(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final OnItemClickListener mItemClickListener;

        final ImageView imageView;
        final TextView textView;
        String data;

        public ViewHolder(View v, OnItemClickListener itemClickListener) {
            super(v);
            mItemClickListener = itemClickListener;

            imageView = v.findViewById(R.id.iv_food);
            imageView.setOnClickListener(v1 -> mItemClickListener.onItemClick());

            textView = v.findViewById(R.id.tv_food);
        }

        public void bindItem(String bindData) {
            data = bindData;
            textView.setText(data);
        }
    }
}