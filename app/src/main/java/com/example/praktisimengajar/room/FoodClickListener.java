package com.example.praktisimengajar.room;

import com.example.praktisimengajar.room.data.local.Food;

public interface FoodClickListener {
    void onClick(Food food);
    void onClickDelete(Food food);
}
