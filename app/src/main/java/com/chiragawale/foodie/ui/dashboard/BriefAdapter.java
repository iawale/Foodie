package com.chiragawale.foodie.ui.dashboard;

import com.robinhood.spark.SparkAdapter;

import java.util.List;

public class BriefAdapter extends SparkAdapter {

    public BriefAdapter(List<List<Float>> yData,int meal_code) {
        this.yData = yData;
        this.meal_code=meal_code;
    }

    private List<List<Float>> yData;
    private int meal_code;

    @Override
    public int getCount() {
        return yData.size();
    }

    @Override
    public Object getItem(int index) {
        return yData.get(index).get(meal_code);
    }

    @Override
    public float getY(int index) {
        return yData.get(index).get(meal_code);
    }

    @Override
    public boolean hasBaseLine() {
        return true;
    }
}
