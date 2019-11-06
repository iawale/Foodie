package com.chiragawale.foodie.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chiragawale.foodie.FoodLogAdapter;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.RealmFood;
import com.chiragawale.foodie.model.RealmFoodEntry;
import com.chiragawale.foodie.ui.DiaryFragment;
import com.chiragawale.foodie.ui.PlaceholderFragment;
import com.chiragawale.foodie.ui.base.BaseFragment;
import com.chiragawale.foodie.utilities.TimeUtils;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class HomeFragment extends BaseFragment {
    private HomeViewModel homeViewModel;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<View> viewsList;
    private Pager pagerAdapter;
    private List<String> titlesList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager viewPager = root.findViewById(R.id.viewpager);
        TabLayout tabLayout = root.findViewById(R.id.tabs);
        viewsList = new ArrayList<>();
        viewsList.add(getView(inflater,container,-2));
        viewsList.add(getView(inflater,container,-1));
        viewsList.add(getView(inflater,container,-0));
        viewsList.add(getView(inflater,container,1));
        viewsList.add(getView(inflater,container,2));

        titlesList = new ArrayList<>();
        titlesList.add(TimeUtils.getFormattedDate(-2)+"");
        titlesList.add(TimeUtils.getFormattedDate(-1)+"");
        titlesList.add(TimeUtils.getFormattedDate(0)+"");
        titlesList.add(TimeUtils.getFormattedDate(1)+"");
        titlesList.add(TimeUtils.getFormattedDate(2)+"");

        // add views which we want to set as pages
        pagerAdapter = new Pager(viewsList, getContext(),titlesList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    public View getView(LayoutInflater inflater, ViewGroup container, int daysFromToday){
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

    public void removeView(View view){
        viewPager.setAdapter(null);
        titlesList.remove(viewsList.indexOf(view));
        viewsList.remove(view);
        //Adapter needs to be reinitialised with new list of views
        pagerAdapter = new Pager(viewsList, getContext(),titlesList);
        viewPager.setAdapter(pagerAdapter);

        pagerAdapter.notifyDataSetChanged();
//      viewPager.setCurrentItem(position);
    }

    public void addView(View view, int position){
        viewsList.add(position, view);
        pagerAdapter.notifyDataSetChanged();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mList = new ArrayList<>();
        private final List<String> mTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }
        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }
        @Override
        public int getCount() {
            return mList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mList.add(fragment);
            mTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
    }
}