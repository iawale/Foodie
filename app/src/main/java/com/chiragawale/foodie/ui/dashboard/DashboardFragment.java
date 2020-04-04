package com.chiragawale.foodie.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    MorphSparkAnimator morphSparkAnimator;
    BriefAdapter mAdapter;
    SparkView sv_calories;
    TextView tv_cal_view;
    SparkView sv_protein;
    TextView tv_protein_view;
    SparkView sv_carbs;
    TextView tv_carbs_view;
    SparkView sv_fat;
    TextView tv_fat_view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        morphSparkAnimator = new MorphSparkAnimator();
        morphSparkAnimator.setDuration(2000L);

        List<List<Float>> dataLists= getDataList(30);

        findView(root);
        setAdapters(dataLists);

        return root;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.dashboard_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_one_month:
                List<List<Float>> dataLists= getDataList(30);
                setAdapters(dataLists);
                return true;

            case R.id.menu_three_month:
                dataLists= getDataList(90);
                setAdapters(dataLists);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<List<Float>> getDataList( int j){
        List<List<Float>> dataLists=new ArrayList<>();
        for(int i=j-1;i>=0;i--) {
            List<Float> dayData = progressDao.getProgressByDay(foodDao.getFoodByDate(0-i));
            dataLists.add(dayData);
        }
        return dataLists;
    }

    private void setAdapters(List<List<Float>> dataLists){
        mAdapter = new BriefAdapter(dataLists,progressDao.CALORIE_CODE);
        sv_calories.setAdapter(mAdapter);
        sv_calories.setSparkAnimator(morphSparkAnimator);
        sv_calories.setScrubListener(value -> {
            if (value != null) tv_cal_view.setText("Calories: " + value);
        });

        mAdapter = new BriefAdapter(dataLists,progressDao.PROTEIN_CODE);
        sv_protein.setAdapter(mAdapter);
        sv_protein.setSparkAnimator(morphSparkAnimator);
        sv_protein.setScrubListener(value -> {
            if (value != null) tv_protein_view.setText("Protein: " + value);
        });

        mAdapter = new BriefAdapter(dataLists,progressDao.CARBS_CODE);
        sv_carbs.setAdapter(mAdapter);
        sv_carbs.setSparkAnimator(morphSparkAnimator);
        sv_carbs.setScrubListener(value -> {
            if (value != null) tv_carbs_view.setText("Carbs: " + value);
        });

        mAdapter = new BriefAdapter(dataLists,progressDao.FAT_CODE);
        sv_fat.setAdapter(mAdapter);
        sv_fat.setSparkAnimator(morphSparkAnimator);
        sv_fat.setScrubListener(value -> {
            if (value != null) tv_fat_view.setText("Fat: " + value);
        });
    }

    private void findView(View root){
        sv_calories = root.findViewById(R.id.sv_calories);
        tv_cal_view = root.findViewById(R.id.tv_calories);
        sv_protein = root.findViewById(R.id.sv_protein);
        tv_protein_view = root.findViewById(R.id.tv_protein);
        sv_carbs = root.findViewById(R.id.sv_carbs);
        tv_carbs_view = root.findViewById(R.id.tv_carbs);
        sv_fat = root.findViewById(R.id.sv_fat);
        tv_fat_view = root.findViewById(R.id.tv_fat);

    }
}