package com.chiragawale.foodie.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.chiragawale.foodie.R;
import com.chiragawale.foodie.ui.base.BaseFragment;
import com.robinhood.spark.SparkView;
import com.robinhood.spark.animation.MorphSparkAnimator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends BaseFragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        MorphSparkAnimator morphSparkAnimator = new MorphSparkAnimator();
        morphSparkAnimator.setDuration(2000L);

        List<List<Float>> dataLists= new ArrayList<>();

        for(int i=0;i<30;i++) {
            List<Float> dayData = progressDao.getProgressByDay(foodDao.getFoodByDate(0-i));
            dataLists.add(dayData);
        }

        BriefAdapter mAdapter = new BriefAdapter(dataLists,progressDao.CALORIE_CODE);
        SparkView sv_calories = root.findViewById(R.id.sv_calories);
        TextView tv_cal_view = root.findViewById(R.id.tv_calories);
        sv_calories.setAdapter(mAdapter);
        sv_calories.setSparkAnimator(morphSparkAnimator);
        sv_calories.setScrubListener(value -> {
            if (value != null) tv_cal_view.setText("Calories: " + value);
        });

        mAdapter = new BriefAdapter(dataLists,progressDao.PROTEIN_CODE);
        SparkView sv_protein = root.findViewById(R.id.sv_protein);
        TextView tv_protein_view = root.findViewById(R.id.tv_protein);
        sv_protein.setAdapter(mAdapter);
        sv_protein.setSparkAnimator(morphSparkAnimator);
        sv_protein.setScrubListener(value -> {
            if (value != null) tv_protein_view.setText("Protein: " + value);
        });

        mAdapter = new BriefAdapter(dataLists,progressDao.CARBS_CODE);
        SparkView sv_carbs = root.findViewById(R.id.sv_carbs);
        TextView tv_carbs_view = root.findViewById(R.id.tv_carbs);
        sv_carbs.setAdapter(mAdapter);
        sv_carbs.setSparkAnimator(morphSparkAnimator);
        sv_carbs.setScrubListener(value -> {
            if (value != null) tv_carbs_view.setText("Carbs: " + value);
        });
        
        mAdapter = new BriefAdapter(dataLists,progressDao.FAT_CODE);
        SparkView sv_fat = root.findViewById(R.id.sv_fat);
        TextView tv_fat_view = root.findViewById(R.id.tv_fat);
        sv_fat.setAdapter(mAdapter);
        sv_fat.setSparkAnimator(morphSparkAnimator);
        sv_fat.setScrubListener(value -> {
            if (value != null) tv_fat_view.setText("Fat: " + value);
        });
        return root;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        inflater.inflate(R.menu.dashboard_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }


}