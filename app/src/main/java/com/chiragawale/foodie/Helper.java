package com.chiragawale.foodie;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Helper {
    static FragmentManager manager;

    public static void setManager(FragmentManager manager) {
        Helper.manager = manager;
    }

    public static void OpenFragment(Fragment f){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,f);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
