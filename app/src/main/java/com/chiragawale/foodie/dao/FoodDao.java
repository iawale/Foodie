package com.chiragawale.foodie.dao;

import com.chiragawale.foodie.model.ApiFoodEntry;
import com.chiragawale.foodie.model.RealmFoodEntry;
import java.util.List;

public interface FoodDao {
    void quickAddFood(final RealmFoodEntry food);
    List<ApiFoodEntry> getAllFood();
    List<RealmFoodEntry> getFoodByDate(int daysFromToday);
    List<List<RealmFoodEntry>>  getFoodByMealCode(int daysFromToday);
    void addSearchHistory(final ApiFoodEntry food);
}
