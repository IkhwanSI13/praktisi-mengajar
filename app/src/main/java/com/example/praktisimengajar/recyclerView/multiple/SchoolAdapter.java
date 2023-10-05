package com.example.praktisimengajar.recyclerView.multiple;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktisimengajar.R;
import com.example.praktisimengajar.recyclerView.multiple.model.School;
import com.example.praktisimengajar.recyclerView.multiple.model.University;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.BaseViewHolder> {
    public static final int TYPE_SCHOOL = 0;
    public static final int TYPE_UNIVERSITY = 1;

    private List<Object> data;

    public SchoolAdapter(List<Object> dataSet) {
        data = dataSet;
    }

    @Override
    public int getItemViewType(int position) {
        Object object = data.get(position);
        if (object instanceof School) {
            return TYPE_SCHOOL;
        } else if (object instanceof University) {
            return TYPE_UNIVERSITY;
        }

        throw new IllegalArgumentException("Invalid position " + position);
    }

    @NonNull
    @Override
    public SchoolAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case TYPE_SCHOOL: {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.school_item,
                        viewGroup, false);
                return new SchoolViewHolder(view);
            }
            case TYPE_UNIVERSITY: {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.university_item,
                        viewGroup, false);
                return new UniversityViewHolder(view);
            }
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public void onBindViewHolder(SchoolAdapter.BaseViewHolder viewHolder, final int position) {
        Object element = data.get(position);
        if (viewHolder instanceof SchoolViewHolder) {
            viewHolder.bind((School) element);
        } else if (viewHolder instanceof UniversityViewHolder) {
            viewHolder.bind((University) element);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public abstract static class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        private BaseViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bind(T type);
    }

    public class SchoolViewHolder extends BaseViewHolder<School> {
        final TextView tvName;
        final TextView tvAddress;
        School data;

        private SchoolViewHolder(View v) {
            super(v);
            v.setOnClickListener(
                    v1 -> Toast.makeText(v1.getContext(), data.getName(), Toast.LENGTH_LONG).show()
            );

            tvName = v.findViewById(R.id.tv_name);
            tvAddress = v.findViewById(R.id.tv_address);
        }

        @Override
        public void bind(School newData) {
            data = newData;
            tvName.setText(data.getName());
            tvAddress.setText(data.getAddress());
        }
    }

    public class UniversityViewHolder extends BaseViewHolder<University> {
        final TextView tvName;
        final TextView tvMajor;
        University data;

        private UniversityViewHolder(View v) {
            super(v);
            v.setOnClickListener(
                    v1 -> Toast.makeText(v1.getContext(), data.getName(), Toast.LENGTH_LONG).show()
            );

            tvName = v.findViewById(R.id.tv_name);
            tvMajor = v.findViewById(R.id.tv_major);
        }

        @Override
        public void bind(University newData) {
            data = newData;
            tvName.setText(data.getName());
            tvMajor.setText(data.getMajorsCount() + " Major");
        }
    }
}