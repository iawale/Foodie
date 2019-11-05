package com.chiragawale.foodie.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.foodie.FoodLogAdapter;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.RealmFoodEntry;
import com.chiragawale.foodie.ui.base.BaseFragment;

import java.util.List;

import io.realm.Realm;

public class DiaryFragment extends BaseFragment {
    private int daysFromToday;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public DiaryFragment(int daysFromToday) {
        this.daysFromToday = daysFromToday;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_diary_view, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Realm realm = Realm.getDefaultInstance();
        List<RealmFoodEntry> realmFoodList = foodDao.getFoodByDate(daysFromToday);

        // specify an adapter (see also next example)
        mAdapter = new FoodLogAdapter(realmFoodList, getContext());
        recyclerView.setAdapter(mAdapter);
        return root;
    }
}
