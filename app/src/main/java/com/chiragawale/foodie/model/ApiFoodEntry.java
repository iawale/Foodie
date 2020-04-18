package com.chiragawale.foodie.model;

import io.realm.RealmObject;

public class ApiFoodEntry extends RealmObject {
    private long entryTime;
    private int mealTimeCode;
    private String name;
    private String calories, fat, protein, carbs;

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public int getMealTimeCode() {
        return mealTimeCode;
    }

    public void setMealTimeCode(int mealTimeCode) {
        this.mealTimeCode = mealTimeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public ApiFoodEntry() {
    }
}
