package com.chiragawale.foodie.ui.addFood;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.foodie.MainActivity;
import com.chiragawale.foodie.R;
import com.chiragawale.foodie.model.ApiFoodEntry;
import com.chiragawale.foodie.model.RealmFoodEntry;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import static com.chiragawale.foodie.ui.base.BaseFragment.foodDao;

public class AddFoodAdapter extends RecyclerView.Adapter<AddFoodAdapter.ViewHolder> {

    private List<ApiFoodEntry> list;
    private Context context;
    private int mMealTimeCode;
    private long mEntryTime;
    private FragmentActivity mActivity;

    public AddFoodAdapter(List<ApiFoodEntry> list, Context context, int mealTimeCode, long entryTime, FragmentActivity activity) {
        this.list = list;
        this.context = context;
        this.mMealTimeCode=mealTimeCode;
        this.mEntryTime=entryTime;
        this.mActivity=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_search_food, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("View", "Recycler View");
        holder.title_textView.setText(list.get(position).getName());
        holder.calorie_textView.setText(list.get(position).getCalories());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Click", "Click on"+list.get(position).getName()+list.get(position).getCalories());

                RealmFoodEntry food = new RealmFoodEntry();
                food.setName(list.get(position).getName());
                food.setCalories(getDouble(list.get(position).getCalories()));
                food.setProtein(getDouble(list.get(position).getProtein()));
                food.setCarbs(getDouble(list.get(position).getCarbs()));
                food.setTotalFat(getDouble(list.get(position).getFat()));
                food.setMealTimeCode(mMealTimeCode);
                food.setEntryTime(mEntryTime);
                Log.e("DATE", food.getEntryTime()+ "");
                foodDao.quickAddFood(food);

                Toast.makeText(context,""+list.get(position).getName()+" added",Toast.LENGTH_SHORT).show();
                mActivity.startActivity(new Intent(mActivity, MainActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title_textView;
        TextView calorie_textView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_textView=itemView.findViewById(R.id.title_textView);
            calorie_textView=itemView.findViewById(R.id.calories_textView);
            linearLayout=itemView.findViewById(R.id.parent_layout);
        }
    }

    public Double getDouble(String value) {
        //String value = et.getText().toString();
        if (value.matches("")) return 0.0;
        else return Double.parseDouble(value);
    }
}
