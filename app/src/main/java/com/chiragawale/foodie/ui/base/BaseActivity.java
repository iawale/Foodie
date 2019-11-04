package com.chiragawale.foodie.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chiragawale.foodie.dao.FoodDao;
import com.chiragawale.foodie.dao.impl.FoodDaoImpl;
import com.chiragawale.foodie.migration.DbMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

public class BaseActivity extends DbBase {
    public static FoodDao foodDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodDao = new FoodDaoImpl();
    }


}
