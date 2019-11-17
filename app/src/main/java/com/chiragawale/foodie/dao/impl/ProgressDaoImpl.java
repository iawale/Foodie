package com.chiragawale.foodie.dao.impl;

import com.chiragawale.foodie.dao.ProgressDao;
import com.chiragawale.foodie.model.RealmFoodEntry;

import java.util.ArrayList;
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
        totalProgress[FAT_CODE] += checkOverFlow(fat);
        totalProgress[CARBS_CODE] += checkOverFlow(carbs);
        totalProgress[PROTEIN_CODE] += checkOverFlow(protein);
        totalProgress[CALORIE_CODE] += checkOverFlow(calorie);
        return totalProgress;
    }

    @Override
    public List<List<Float>> getProgressData(List<RealmFoodEntry> realmFoodEntries){
        List<List<Float>> dataLists = new ArrayList<>();
        List<Float> calData = new ArrayList<>();
        List<Float> carbsData = new ArrayList<>();
        List<Float> proteinData = new ArrayList<>();
        List<Float> fatData = new ArrayList<>();
        for(RealmFoodEntry entry: realmFoodEntries){
            calData.add((float) entry.getCalories());
            carbsData.add((float) entry.getCarbs());
            proteinData.add((float) entry.getProtein());
            fatData.add((float) entry.getTotalFat());
        }
        dataLists.add(fatData);
        dataLists.add(carbsData);
        dataLists.add(proteinData);
        dataLists.add(calData);
        return dataLists;
    }

    public int checkOverFlow(int nutrient){
        if(nutrient > 100) return 100;
            else return nutrient;
    }
}
