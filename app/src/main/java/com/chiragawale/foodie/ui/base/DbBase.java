package com.chiragawale.foodie.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chiragawale.foodie.migration.DbMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class DbBase extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(2) // Must be bumped when the schema changes
                .migration(new DbMigration() {
                }) // Migration to run instead of throwing an exception
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
