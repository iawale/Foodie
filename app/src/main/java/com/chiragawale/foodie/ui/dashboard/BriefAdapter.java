package com.chiragawale.foodie.ui.dashboard;

import com.robinhood.spark.SparkAdapter;

import java.util.List;

public class BriefAdapter extends SparkAdapter {

    public BriefAdapter(List<List<Float>> yData, int CODE) {
        this.yData = yData;
        this.code=CODE;
    }

    private List<List<Float>> yData;

    @Override
    public int getCount() {
        return yData.size();
    }

    @Override
    public Object getItem(int index) {
        return yData.get(index);
    }

    @Override
    public float getY(int index) {
        return yData.get(index);
    }

    @Override
    public boolean hasBaseLine() {
        return true;
    }
}
