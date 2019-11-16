package com.chiragawale.foodie.ui.dashboard;

import android.animation.Animator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chiragawale.foodie.R;
import com.chiragawale.foodie.dao.ProgressDao;
import com.chiragawale.foodie.ui.base.BaseFragment;
import com.robinhood.spark.SparkView;
import com.robinhood.spark.animation.LineSparkAnimator;
import com.robinhood.spark.animation.MorphSparkAnimator;
import com.robinhood.spark.animation.SparkAnimator;

public class DashboardFragment extends BaseFragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        SparkView sparkView = root.findViewById(R.id.sparkview);
        BriefAdapter mAdapter = new BriefAdapter(progressDao.getCalorieData(foodDao.getAllFood()));
        sparkView.setAdapter(mAdapter);
        // set animator
        MorphSparkAnimator morphSparkAnimator = new MorphSparkAnimator();
        morphSparkAnimator.setDuration(2000L);
        sparkView.setSparkAnimator(morphSparkAnimator);
        return root;
    }
}