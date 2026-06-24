package com.example.hungerstation;

import com.example.hungerstation.model.Food;
import java.util.ArrayList;

public class CartManager {

    public static ArrayList<Food> cartItems = new ArrayList<>();

    public static void addToCart(Food food) {

        for (Food item : cartItems) {

            if (item.getname().equals(food.getname())) {

                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        food.setQuantity(1);
        cartItems.add(food);
    }

    public static void increaseQuantity(Food food) {
        food.setQuantity(food.getQuantity() + 1);
    }

    public static void decreaseQuantity(Food food) {

        food.setQuantity(food.getQuantity() - 1);

        if (food.getQuantity() <= 0) {
            cartItems.remove(food);
        }
    }
}