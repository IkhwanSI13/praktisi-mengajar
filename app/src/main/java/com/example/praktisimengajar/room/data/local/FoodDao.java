package com.example.praktisimengajar.room.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM food")
    List<Food> getAll();

    @Query("SELECT * FROM food WHERE id IN (:ids)")
    List<Food> loadAllByIds(int[] ids);

    @Query("SELECT * FROM food WHERE foodName LIKE :name LIMIT 1")
    Food findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Food foods);

    @Insert
    void insertAll(Food... foods);

    @Delete
    void delete(Food user);
}
