package com.chiragawale.foodie.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.chiragawale.foodie.R;
import com.chiragawale.foodie.ui.base.BaseFragment;
import com.robinhood.spark.SparkView;
import com.robinhood.spark.animation.MorphSparkAnimator;

public class DashboardFragment extends BaseFragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        SparkView sparkView = root.findViewById(R.id.sparkview);
        BriefAdapter mAdapter = new BriefAdapter(progressDao.getCalorieData(foodDao.getAllFood()));
        TextView tv_calView = root.findViewById(R.id.tv_cal);
        sparkView.setAdapter(mAdapter);
        // set animator
        MorphSparkAnimator morphSparkAnimator = new MorphSparkAnimator();
        morphSparkAnimator.setDuration(2000L);
        sparkView.setSparkAnimator(morphSparkAnimator);
        sparkView.setScrubListener(value -> {
            if (value == null) {
                Toast.makeText(getContext(),"No value", Toast.LENGTH_SHORT).show();
            } else {
                tv_calView.setText("Calories: " + value);
            }
        });
        return root;
    }
}