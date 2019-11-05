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
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class HomeFragment extends BaseFragment {
    private HomeViewModel homeViewModel;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = root.findViewById(R.id.tabs);
        viewPager = root.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new DiaryFragment(0), "ONE");
        adapter.addFragment(new DiaryFragment(-1), "TWO");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
        return root;
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