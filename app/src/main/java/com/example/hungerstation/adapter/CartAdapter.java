package com.example.hungerstation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hungerstation.CartManager;
import com.example.hungerstation.R;
import com.example.hungerstation.model.Food;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Food> cartItems;
    private OnCartChangedListener listener;

    public CartAdapter(ArrayList<Food> cartItems,
                       OnCartChangedListener listener) {

        this.cartItems = cartItems;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView foodPic, btnAdd, btnminus;
        TextView fName, fPrice, fQuantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodPic = itemView.findViewById(R.id.foodPic);
            fName = itemView.findViewById(R.id.fName);
            fPrice = itemView.findViewById(R.id.fPrice);
            fQuantity = itemView.findViewById(R.id.fQuantity);
            btnAdd = itemView.findViewById(R.id.btnadd);
            btnminus = itemView.findViewById(R.id.btnMinus);
            fQuantity = itemView.findViewById(R.id.fQuantity);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartrecycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Food food = cartItems.get(position);

        holder.fName.setText(food.getname());
        holder.fPrice.setText(food.getPrice());
        holder.foodPic.setImageResource(food.getImage());

        holder.fQuantity.setText(
                String.valueOf(food.getQuantity())
        );

        holder.btnAdd.setOnClickListener(v -> {

            CartManager.increaseQuantity(food);

            holder.fQuantity.setText(
                    String.valueOf(food.getQuantity())
            );

            notifyItemChanged(position);
            listener.onCartChanged();
        });

        holder.btnminus.setOnClickListener(v -> {

            CartManager.decreaseQuantity(food);

            if (food.getQuantity() <= 0) {

                notifyDataSetChanged();

            } else {

                holder.fQuantity.setText(
                        String.valueOf(food.getQuantity())
                );

                notifyItemChanged(position);

            }
            listener.onCartChanged();
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
    public interface OnCartChangedListener {
        void onCartChanged();
    }
}