package com.chiragawale.foodie.dao;

import com.chiragawale.foodie.model.RealmFoodEntry;

import java.util.List;

public interface ProgressDao {
    int FAT_PROGRESS = 0;
    int CARBS_PROGRESS = 1;
    int PROTEIN_PROGRESS = 2;
    int CALORIE_PROGRESS = 3;

    int[] getFatProgress(List<RealmFoodEntry> realmFoodEntries);
}
