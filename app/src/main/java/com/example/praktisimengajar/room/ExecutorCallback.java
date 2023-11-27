package com.example.praktisimengajar.room;

import com.example.praktisimengajar.room.data.local.Food;

import java.util.List;

public interface ExecutorCallback {
    void onComplete(List<Food> result);
}
