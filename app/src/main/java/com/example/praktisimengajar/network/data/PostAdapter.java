package com.example.praktisimengajar.network.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.network.data.model.Posts;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    final List<Posts> mDataSet;

    public PostAdapter(List<Posts> dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_item, viewGroup, false);

        return new PostAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.bindItem(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDesc;

        Posts data;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(
                    v1 -> Toast.makeText(v1.getContext(), data.getTitle(), Toast.LENGTH_LONG).show()
            );

            tvTitle = (TextView) v.findViewById(R.id.tv_title);
            tvDesc = (TextView) v.findViewById(R.id.tv_desc);
        }

        public void bindItem(Posts bindData) {
            data = bindData;
            tvTitle.setText(data.getTitle());
            tvDesc.setText(data.getBody());
        }
    }
}