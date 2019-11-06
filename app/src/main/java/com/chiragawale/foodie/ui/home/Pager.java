package com.chiragawale.foodie.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

class Pager extends PagerAdapter {

    List<View> views;
    List<String> pageTitles;
    Context context;

    public Pager(List<View> views, Context context, List<String> pageTitles) {
        this.views = views;
        this.context = context;
        this.pageTitles = pageTitles;
    }

    public View getView(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public int getItemPosition(Object object) {
        for(int index = 0 ; index < getCount() ; index++){
            if((View)object == views.get(index)) {
                return index;
            }
        }
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }

}