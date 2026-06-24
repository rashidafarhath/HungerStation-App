package com.example.hungerstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hungerstation.adapter.CartAdapter;

import com.example.hungerstation.model.Food;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    ImageView back;
    TextView checkout;
    ArrayList<Food> cartItems = CartManager.cartItems;
    RecyclerView cartRecycler;
    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        cartRecycler = findViewById(R.id.recyclerViewCart);

        cartRecycler.setLayoutManager(
                new LinearLayoutManager(this)
        );

        adapter = new CartAdapter(cartItems, () -> {
            updateTotal();

            if (cartItems.isEmpty()) {

                checkout.setEnabled(false);
                checkout.setAlpha(0.5f);
                checkout.setText("Cart Is Empty");

            } else {

                checkout.setEnabled(true);
                checkout.setAlpha(1f);
                checkout.setText("Check Out");
            }
        });

        cartRecycler.setAdapter(adapter);

        back=findViewById(R.id.back);
        checkout=findViewById(R.id.checkout);

        Toast.makeText(
                this,
                "Items in cart: " + cartItems.size(),
                Toast.LENGTH_LONG
        ).show();

        checkout = findViewById(R.id.checkout);

        if (cartItems.isEmpty()) {

            checkout.setEnabled(false);
            checkout.setAlpha(0.5f);
            checkout.setText("Cart Is Empty");

        } else {

            checkout.setEnabled(true);
            checkout.setAlpha(1f);
            checkout.setText("Check Out");
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
                finish();
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), CheckOut.class);
                startActivity(intent);
                finish();
            }
        });
        for(Food item : cartItems){

            String name = item.getname();
            int qty = item.getQuantity();

        }



//        double total = 0;
//
//        for (Food item : cartItems) {
//
//            String priceString = item.getPrice()
//                    .replace("Rs.", "")
//                    .trim();
//
//            double price = Double.parseDouble(priceString);
//
//            total += price * item.getQuantity();
//        }
//
//        txtTotal.setText("Total: Rs. " + total);
        updateTotal();
    }

    private void updateTotal() {
        TextView txtTotal = findViewById(R.id.txtTotal);

        double total = 0;

        for (Food item : cartItems) {

            String priceString = item.getPrice()
                    .replace("Rs.", "")
                    .trim();

            double price = Double.parseDouble(priceString);

            total += price * item.getQuantity();
        }

        txtTotal.setText("Total: Rs. " + total);
    }
}