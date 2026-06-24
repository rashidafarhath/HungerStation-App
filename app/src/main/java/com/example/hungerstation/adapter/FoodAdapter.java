package com.example.hungerstation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hungerstation.CartManager;
import com.example.hungerstation.R;
import com.example.hungerstation.model.Food;
import java.util.ArrayList;
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    ArrayList<Food> foodList;

    public FoodAdapter(ArrayList<Food> foodList) {
        this.foodList = foodList;
}
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodPic;
        TextView fName, fPrice;
        TextView btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodPic = itemView.findViewById(R.id.foodPic);
            fName = itemView.findViewById(R.id.fName);
            fPrice = itemView.findViewById(R.id.fPrice);
            btnAdd=itemView.findViewById(R.id.btnAdd);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerr, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Food food = foodList.get(position);

        holder.fName.setText(food.getname());
        holder.fPrice.setText(food.getPrice());
        holder.foodPic.setImageResource(food.getImage());
        holder.btnAdd.setOnClickListener(v -> {
            CartManager.addToCart(food);

            Toast.makeText(
                    holder.itemView.getContext(),
                    food.getname() + " added",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
