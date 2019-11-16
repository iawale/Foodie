package com.chiragawale.foodie.dao.impl;

import com.chiragawale.foodie.dao.ProgressDao;
import com.chiragawale.foodie.model.RealmFoodEntry;

import java.util.List;

import io.realm.Realm;

public class ProgressDaoImpl implements ProgressDao {
    private Realm realm = Realm.getDefaultInstance();


    @Override
    public int [] getFatProgress(List<RealmFoodEntry> realmFoodEntries) {
        int [] totalProgress = new int [4];
        int fat=0,carbs=0,protein =0,calorie =0;
        for(RealmFoodEntry entry: realmFoodEntries){
            fat += entry.getTotalFat();
            carbs += entry.getCarbs();
            protein += entry.getProtein();
            calorie += entry.getCalories();
        }
        totalProgress[FAT_PROGRESS] += checkOverFlow(fat);
        totalProgress[CARBS_PROGRESS] += checkOverFlow(carbs);
        totalProgress[PROTEIN_PROGRESS] += checkOverFlow(protein);
        totalProgress[CALORIE_PROGRESS] += checkOverFlow(calorie);
        return totalProgress;
    }

    public int checkOverFlow(int nutrient){
        if(nutrient > 100) return 100;
            else return nutrient;
    }
}
