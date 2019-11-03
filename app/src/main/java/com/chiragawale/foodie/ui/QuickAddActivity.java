package com.chiragawale.foodie.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.RealmFood;
import com.google.android.material.textfield.TextInputEditText;

import io.realm.Realm;

public class QuickAddActivity extends AppCompatActivity {

    TextInputEditText et_name,et_calories,et_protein,et_fat,et_carbs;

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
        final Realm realm = Realm.getDefaultInstance();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmFood food = realm.createObject(RealmFood.class);
                        food.setName(et_name.getText().toString());
                        food.setCalories(Double.parseDouble(et_calories.getText().toString()));
                        food.setProtein(Double.parseDouble(et_protein.getText().toString()));
                        food.setCarbs(Double.parseDouble(et_carbs.getText().toString()));
                        food.setTotalFat(Double.parseDouble(et_fat.getText().toString()));
                    }
                });
            }
        });
    }
}
