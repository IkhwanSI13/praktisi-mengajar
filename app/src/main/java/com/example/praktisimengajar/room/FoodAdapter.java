package com.example.praktisimengajar.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.room.data.local.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    final List<Food> mDataSet;
    final FoodClickListener mfoodClickListener;

    public FoodAdapter(List<Food> dataSet, FoodClickListener foodClickListener) {
        mDataSet = dataSet;
        mfoodClickListener = foodClickListener;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.food_item2, viewGroup, false);

        return new FoodAdapter.ViewHolder(v, mfoodClickListener);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.bindItem(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final FoodClickListener mfoodClickListener;

        final TextView tvTitle;
        final TextView tvDesc;
        final ImageView ivDelete;

        Food data;

        public ViewHolder(View v, FoodClickListener foodClickListener) {
            super(v);
            mfoodClickListener = foodClickListener;

            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvDesc = (TextView) v.findViewById(R.id.tv_desc);
            ivDelete = (ImageView) v.findViewById(R.id.iv_delete);

            v.setOnClickListener(
                    view -> foodClickListener.onClick(data)
            );
            ivDelete.setOnClickListener(
                    view -> foodClickListener.onClickDelete(data)
            );
        }

        public void bindItem(Food bindData) {
            data = bindData;
            tvTitle.setText(data.name);
            tvDesc.setText(data.price);
        }
    }
}