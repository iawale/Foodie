package com.chiragawale.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.foodie.model.RealmFood;
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ((ViewHolderMyLife) holder).title.setText(realmFoodList.get(position).getName());
            }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return realmFoodList.size();
            }

        class ViewHolderMyLife extends RecyclerView.ViewHolder {
            TextView title;

            public ViewHolderMyLife(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.tv_food_name);
            }

        }

}