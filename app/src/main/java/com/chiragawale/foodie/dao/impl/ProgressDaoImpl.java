package com.chiragawale.foodie.dao.impl;

import android.util.Log;
import android.widget.Toast;

import com.chiragawale.foodie.dao.ProgressDao;
import com.chiragawale.foodie.model.RealmFoodEntry;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class ProgressDaoImpl implements ProgressDao {
    private Realm realm = Realm.getDefaultInstance();
    private int [] GOAL = {35,130,120,2000};

    @Override
    public int [] getProgress(List<RealmFoodEntry> realmFoodEntries) {
        int [] totalProgress = new int [4];
        int fat=0,carbs=0,protein =0,calorie =0;
        for(RealmFoodEntry entry: realmFoodEntries){
            fat += entry.getTotalFat();
            carbs += entry.getCarbs();
            protein += entry.getProtein();
            calorie += entry.getCalories();
        }
        totalProgress[FAT_CODE] += getNormalizedPercent(fat,FAT_CODE);
        totalProgress[CARBS_CODE] += getNormalizedPercent(carbs,CARBS_CODE);
        totalProgress[PROTEIN_CODE] += getNormalizedPercent(protein,PROTEIN_CODE);
        totalProgress[CALORIE_CODE] += getNormalizedPercent(calorie,CALORIE_CODE);
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

    public List<Float> getProgressByDay(List<RealmFoodEntry> realmFoodEntries){
        List<Float> dataLists=new ArrayList<>();
        float calData=0f,carbsData=0f,proteinData=0f,fatData=0f;
        for(RealmFoodEntry entry: realmFoodEntries){
            calData+=(float)entry.getCalories();
            carbsData+=(float)entry.getCarbs();
            proteinData+=(float) entry.getProtein();
            fatData+=(float) entry.getTotalFat();
        }
        dataLists.add(fatData);
        dataLists.add(carbsData);
        dataLists.add(proteinData);
        dataLists.add(calData);
        return dataLists;
    }


    public int getNormalizedPercent(int nutrient, int code){
        int percent = ((nutrient * 100)/GOAL[code]);
        if (percent > 100) return 100;
        else return percent;
    }
}
