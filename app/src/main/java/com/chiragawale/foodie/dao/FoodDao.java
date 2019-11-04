package com.chiragawale.foodie.dao;

import com.chiragawale.foodie.model.RealmFoodEntry;
import java.util.List;

public interface FoodDao {
    void quickAddFood(final RealmFoodEntry food);
    List<RealmFoodEntry> getAllFood();
}
