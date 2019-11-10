package com.chiragawale.foodie.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chiragawale.foodie.FoodLogAdapter;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.RealmFoodEntry;
import com.chiragawale.foodie.ui.base.BaseFragment;
import com.chiragawale.foodie.utilities.TimeUtils;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class HomeFragment extends BaseFragment {
    private final int SNACKS_MEAL_CODE = 0;
    private final int BREAKFAST_MEAL_CODE = 1;
    private final int LUNCH_MEAL_CODE = 2;
    private final int DINNER_MEAL_CODE = 3;

    private HomeViewModel homeViewModel;
    private ViewPager viewPager;
    private RecyclerView rv_snacks,rv_breakfast,rv_lunch,rv_dinner;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager lm_snacks,lm_breakfast,lm_lunch,lm_dinner;
    private int leftPageDays = -2;
    private int rightPageDays = 2;
    private List<View> viewsList;
    private Pager pagerAdapter;
    private List<String> titlesList;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = root.findViewById(R.id.viewpager);
        TabLayout tabLayout = root.findViewById(R.id.tabs);
        viewsList = new ArrayList<>();
        viewsList.add(getView(inflater,container,-1));
        viewsList.add(getView(inflater,container,-0));
        viewsList.add(getView(inflater,container,1));

        titlesList = new ArrayList<>();
        titlesList.add(TimeUtils.getFormattedDate(-1)+"");
        titlesList.add(TimeUtils.getFormattedDate(0)+"");
        titlesList.add(TimeUtils.getFormattedDate(1)+"");

        // add views which we want to set as pages
        pagerAdapter = new Pager(viewsList, getContext(),titlesList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                      addView(getView(inflater,container,leftPageDays),0,leftPageDays);
                      removeView(viewsList.get(viewsList.size()-1));
                      leftPageDays --;
                      rightPageDays--;
                } else if(position == viewsList.size() - 1){
                      addView(getView(inflater,container,rightPageDays), viewsList.size(), rightPageDays);
                      removeView(viewsList.get(0));
                      rightPageDays++;
                      leftPageDays++;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return root;
    }

    public View getView(LayoutInflater inflater, ViewGroup container, int daysFromToday){
        View root = inflater.inflate(R.layout.fragment_diary_view, container, false);
        lm_snacks = new LinearLayoutManager(getContext());
        lm_breakfast = new LinearLayoutManager(getContext());
        lm_lunch = new LinearLayoutManager(getContext());
        lm_dinner = new LinearLayoutManager(getContext());
        Realm realm = Realm.getDefaultInstance();
        List<List<RealmFoodEntry>> realmFoodLists = foodDao.getFoodByMealCode(daysFromToday);

        rv_snacks = root.findViewById(R.id.rv_snacks);
        mAdapter = new FoodLogAdapter(realmFoodLists.get(SNACKS_MEAL_CODE), getContext());
        rv_snacks.setAdapter(mAdapter);

        rv_breakfast = root.findViewById(R.id.rv_breakfast);
        mAdapter = new FoodLogAdapter(realmFoodLists.get(BREAKFAST_MEAL_CODE), getContext());
        rv_breakfast.setAdapter(mAdapter);

        rv_lunch = root.findViewById(R.id.rv_lunch);
        mAdapter = new FoodLogAdapter(realmFoodLists.get(LUNCH_MEAL_CODE), getContext());
        rv_lunch.setAdapter(mAdapter);

        rv_dinner = root.findViewById(R.id.rv_dinner);
        mAdapter = new FoodLogAdapter(realmFoodLists.get(DINNER_MEAL_CODE), getContext());
        rv_dinner.setAdapter(mAdapter);

        rv_snacks.setLayoutManager(lm_snacks);
        rv_breakfast.setLayoutManager(lm_breakfast);
        rv_lunch.setLayoutManager(lm_lunch);
        rv_dinner.setLayoutManager(lm_dinner);
        return root;
    }

    public void removeView(View view){
        viewPager.setAdapter(null);
        titlesList.remove(viewsList.indexOf(view));
        viewsList.remove(view);
        pagerAdapter = new Pager(viewsList, getContext(),titlesList);
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
        viewPager.setCurrentItem(1);
    }

    public void addView(View view, int position, int days){
        viewsList.add(position, view);
        titlesList.add(position,TimeUtils.getFormattedDate(days));
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