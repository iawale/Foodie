package com.chiragawale.foodie.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chiragawale.foodie.dao.FoodDao;
import com.chiragawale.foodie.dao.impl.FoodDaoImpl;

public class BaseFragment extends Fragment {
    public static final FoodDao foodDao = new FoodDaoImpl();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
