package com.chiragawale.foodie.ui.addFood;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chiragawale.foodie.R;

import java.util.List;

public class AddFoodAdapter extends RecyclerView.Adapter<AddFoodAdapter.ViewHolder> {

    private List<List<String>> list;
    private Context context;

    public AddFoodAdapter(List<List<String>> list, Context context) {
        this.list = list;
        this.context = context;
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
        holder.title_textView.setText(list.get(position).get(0));
        holder.calorie_textView.setText(list.get(position).get(1));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Click", "Click on"+list.get(position).get(0)+list.get(position).get(1));

                Toast.makeText(context,""+list.get(position).get(0)+list.get(position).get(1),Toast.LENGTH_SHORT).show();
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
}
