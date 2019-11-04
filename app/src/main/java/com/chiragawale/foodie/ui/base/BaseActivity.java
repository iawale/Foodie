package com.chiragawale.foodie.ui.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.chiragawale.foodie.dao.FoodDao;
import com.chiragawale.foodie.dao.impl.FoodDaoImpl;

public class BaseActivity extends AppCompatActivity {
    public static FoodDao foodDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodDao = new FoodDaoImpl();
    }


}
