package com.chiragawale.foodie.ui.addFood;

import android.os.Bundle;
import android.widget.Button;

import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.RealmFoodEntry;
import com.chiragawale.foodie.ui.base.BaseActivity;
import com.google.android.material.textfield.TextInputEditText;

import io.realm.Realm;

public class QuickAddActivity extends BaseActivity {

    TextInputEditText et_name, et_calories, et_protein, et_fat, et_carbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_add);
        Button btn_add = findViewById(R.id.btn_add);
        et_name = findViewById(R.id.et_food_name);
        et_calories = findViewById(R.id.et_food_calories);
        et_protein = findViewById(R.id.et_food_protein);
        et_carbs = findViewById(R.id.et_food_carbs);
        et_fat = findViewById(R.id.et_food_fat);

        btn_add.setOnClickListener(v -> {
            RealmFoodEntry food = new RealmFoodEntry();
            food.setName(et_name.getText().toString());
            food.setCalories(getDouble(et_calories));
            food.setProtein(getDouble(et_protein));
            food.setCarbs(getDouble(et_carbs));
            food.setTotalFat(getDouble(et_fat));
            food.setMealTimeCode(getIntent().getExtras().getInt("mealTimeCode"));
            foodDao.quickAddFood(food);
        });
    }

    public Double getDouble(TextInputEditText et) {
        String value = et.getText().toString();
        if (value.matches("")) return 0.0;
        else return Double.parseDouble(value);
    }
}
