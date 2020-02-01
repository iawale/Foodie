package com.chiragawale.foodie.dao;

import com.chiragawale.foodie.model.RealmFoodEntry;

import java.util.List;

public interface ProgressDao {
    int FAT_CODE = 0;
    int CARBS_CODE = 1;
    int PROTEIN_CODE = 2;
    int CALORIE_CODE = 3;

    int[] getProgress(List<RealmFoodEntry> realmFoodEntries);
    List<List<Float>> getProgressData(List<RealmFoodEntry> realmFoodEntries);
}
