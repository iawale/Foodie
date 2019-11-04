package com.chiragawale.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chiragawale.foodie.model.RealmFoodEntry;
import java.util.List;

public class FoodLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<RealmFoodEntry> realmFoodList;
        Context context;

        // Provide a suitable constructor (depends on the kind of dataset)
        public FoodLogAdapter(List<RealmFoodEntry> realmFoodList, Context context) {
            this.realmFoodList = realmFoodList;
            this.context = context;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.row_food_log, parent, false);
            return new ViewHolderMyLife(v);
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            ((ViewHolderMyLife) holder).title.setText(realmFoodList.get(position).getName());
            ((ViewHolderMyLife) holder).calories.setText(realmFoodList.get(position).getCalories() +  "");
            ((ViewHolderMyLife) holder).carbs.setText(realmFoodList.get(position).getCarbs() + "");
            ((ViewHolderMyLife) holder).protein.setText(realmFoodList.get(position).getProtein() + "");
            ((ViewHolderMyLife) holder).fat.setText(realmFoodList.get(position).getTotalFat() + "");
            ((ViewHolderMyLife) holder).ll_food.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int visibility = ((ViewHolderMyLife) holder).ll_food_detail.getVisibility();
                    if(visibility == View.VISIBLE)
                        ((ViewHolderMyLife) holder).ll_food_detail.setVisibility(View.GONE);
                    else
                        ((ViewHolderMyLife) holder).ll_food_detail.setVisibility(View.VISIBLE);
                }
            });
        }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return realmFoodList.size();
            }

        class ViewHolderMyLife extends RecyclerView.ViewHolder {
            TextView title, calories, protein, carbs, fat;
            LinearLayout ll_food, ll_food_detail;

            public ViewHolderMyLife(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.tv_food_name);
                calories = itemView.findViewById(R.id.tv_food_calories);
                protein = itemView.findViewById(R.id.tv_food_protein);
                carbs = itemView.findViewById(R.id.tv_food_carbs);
                fat = itemView.findViewById(R.id.tv_food_fat);
                ll_food = itemView.findViewById(R.id.ll_food);
                ll_food_detail = itemView.findViewById(R.id.ll_food_detail);
            }

        }

}