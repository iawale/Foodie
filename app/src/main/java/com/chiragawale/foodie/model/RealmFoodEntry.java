package com.chiragawale.foodie.model;

import io.realm.RealmObject;

public class RealmFoodEntry extends RealmObject {
    private long entryTime;
    private int mealTimeCode;
    private String name;
    private double servingSize, numberOfServings, calories,
            carbs,totalFat,saturatedFat,transFat,polyUnsaturatedFat,
            monoUnSaturatedFat,protein,cholesterol, sodium,
            dietaryFiber,totalSugars,addedSugars,sugarAlcohols,
            calcium,iron,potassium,vitaminA,vitaminB,vitaminC,vitaminD,
            vitaminE;

    public RealmFoodEntry() {
    }

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

    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public double getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(double numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    public double getPolyUnsaturatedFat() {
        return polyUnsaturatedFat;
    }

    public void setPolyUnsaturatedFat(double polyUnsaturatedFat) {
        this.polyUnsaturatedFat = polyUnsaturatedFat;
    }

    public double getMonoUnSaturatedFat() {
        return monoUnSaturatedFat;
    }

    public void setMonoUnSaturatedFat(double monoUnSaturatedFat) {
        this.monoUnSaturatedFat = monoUnSaturatedFat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public double getTotalSugars() {
        return totalSugars;
    }

    public void setTotalSugars(double totalSugars) {
        this.totalSugars = totalSugars;
    }

    public double getAddedSugars() {
        return addedSugars;
    }

    public void setAddedSugars(double addedSugars) {
        this.addedSugars = addedSugars;
    }

    public double getSugarAlcohols() {
        return sugarAlcohols;
    }

    public void setSugarAlcohols(double sugarAlcohols) {
        this.sugarAlcohols = sugarAlcohols;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public double getVitaminB() {
        return vitaminB;
    }

    public void setVitaminB(double vitaminB) {
        this.vitaminB = vitaminB;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(double vitaminD) {
        this.vitaminD = vitaminD;
    }

    public double getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(double vitaminE) {
        this.vitaminE = vitaminE;
    }
}
