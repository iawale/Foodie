package com.chiragawale.foodie.ui.addFood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.foodie.MainActivity;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.data.api.DataStream;
import com.chiragawale.foodie.model.ApiFoodEntry;
import com.chiragawale.foodie.ui.PageViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AddFoodFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private SearchView et_search;
    private RecyclerView rv_search;
    private RecyclerView.Adapter aAdapter;
    private static int mMealTimeCode;
    private static long mEntryTime;

    public static AddFoodFragment newInstance(int index, int mealCodeTime, long entryTime) {
        AddFoodFragment fragment = new AddFoodFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        mMealTimeCode=mealCodeTime;
        mEntryTime=entryTime;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_food, container, false);
        et_search = root.findViewById(R.id.et_search);
        rv_search=root.findViewById(R.id.rv_food_item);
        et_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText==null && newText.isEmpty()) {newText+=" ";}
                    DataStream dataStream = new DataStream();
                    String result = dataStream.getFoodData(newText);
                    JSONObject obj;
                    List<ApiFoodEntry> apiFoodEntryList = new ArrayList<>();
                    try {
                        String food = "";
                        obj = new JSONObject(result);
                        JSONArray array = obj.getJSONArray("hints");
                        for (int i = 0; i < array.length(); i++) {
                            ApiFoodEntry apiFoodEntry = new ApiFoodEntry();
                            apiFoodEntry.setName(array.getJSONObject(i).getJSONObject("food").getString("label"));
                            apiFoodEntry.setCalories(array.getJSONObject(i).getJSONObject("food").getJSONObject("nutrients").getString("ENERC_KCAL"));
                            apiFoodEntry.setProtein(array.getJSONObject(i).getJSONObject("food").getJSONObject("nutrients").getString("PROCNT"));
                            apiFoodEntry.setFat(array.getJSONObject(i).getJSONObject("food").getJSONObject("nutrients").getString("FAT"));
                            apiFoodEntry.setCarbs(array.getJSONObject(i).getJSONObject("food").getJSONObject("nutrients").getString("CHOCDF"));
                            apiFoodEntryList.add(apiFoodEntry);
                        }
                        aAdapter = new AddFoodAdapter(apiFoodEntryList, getContext(), mMealTimeCode, mEntryTime, getActivity());
                        rv_search.setAdapter(aAdapter);
                        rv_search.setLayoutManager(new LinearLayoutManager(getContext()));
                        // Log.e("names",food);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                return false;
            }
        });
        return root;
    }
}