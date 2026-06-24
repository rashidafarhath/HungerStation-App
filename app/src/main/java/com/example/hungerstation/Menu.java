package com.example.hungerstation;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hungerstation.model.Food;
import com.example.hungerstation.adapter.FoodAdapter;

import java.util.ArrayList;


public class Menu extends AppCompatActivity {

    RecyclerView recyclerView;
    FoodAdapter adapter;
    ArrayList<Food> foodList = new ArrayList<>();
    ArrayList<Food> filterFood = new ArrayList<>();


    TextView catAll, catRice,catKottu,catNoodles;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        foodLoad();

        adapter = new FoodAdapter(filterFood);
        recyclerView.setAdapter(adapter);

        catAll=findViewById(R.id.catAll);
        catRice=findViewById(R.id.catRice);
        catKottu=findViewById(R.id.catKottu);
        catNoodles=findViewById(R.id.catNoodles);
        cart=findViewById(R.id.cart);

        updateSelectedButton(catAll);

        catAll.setOnClickListener(v -> {
            filterFood.clear();
            filterFood.addAll(foodList);
            updateSelectedButton(catAll);
            adapter.notifyDataSetChanged();
        });
        catRice.setOnClickListener(v -> {updateSelectedButton(catRice);filterByCategory("Rice");});
        catKottu.setOnClickListener(v -> {updateSelectedButton(catKottu);filterByCategory("Kottu");});
        catNoodles.setOnClickListener(v -> {updateSelectedButton(catNoodles);filterByCategory("Noodles");});

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Cart.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void updateSelectedButton(TextView selectedButton) {

        catAll.setSelected(false);
        catRice.setSelected(false);
        catKottu.setSelected(false);
        catNoodles.setSelected(false);

        selectedButton.setSelected(true);
    }
    private void foodLoad() {

        foodList.add(new Food(
                "Chicken Biriyani",
                "Rs. 990",
                R.drawable.chickenbiriyani,
                "Rice"
        ));

        foodList.add(new Food(
                "Jeera Rice",
                "Rs. 800",
                R.drawable.jeerarice,
                "Rice"
        ));

        foodList.add(new Food(
                "Nasi Goreng",
                "Rs. 950",
                R.drawable.nasigoreng,
                "Rice"
        ));

        foodList.add(new Food(
                "Prawn Fried Rice",
                "Rs. 1050",
                R.drawable.peawnfried,
                "Rice"
        ));

        foodList.add(new Food(
                "Prawn Biriyani",
                "Rs. 1400",
                R.drawable.prawnbiriyani,
                "Rice"
        ));

        foodList.add(new Food(
                "Roast Chicken Fried Rice",
                "Rs. 990",
                R.drawable.roastchickfried,
                "Rice"
        ));

        foodList.add(new Food(
                "Tandoori Chicken Biriyani",
                "Rs. 1150",
                R.drawable.tandoorichickenbiriyani,
                "Rice"
        ));

        foodList.add(new Food(
                "Veg Puloa Rice",
                "Rs. 890",
                R.drawable.vegpuloa,
                "Rice"
        ));

        foodList.add(new Food(
                "Beef Kottu",
                "Rs. 1100",
                R.drawable.beefkottu,
                "Kottu"
        ));

        foodList.add(new Food(
                "Egg Kottu",
                "Rs. 650",
                R.drawable.eggkottu,
                "Kottu"
        ));

        foodList.add(new Food(
                "Spicy Chicken Kottu",
                "Rs. 1050",
                R.drawable.spicychickenkottu,
                "Kottu"
        ));

        foodList.add(new Food(
                "Veg Kottu",
                "Rs. 600",
                R.drawable.vegkottu,
                "Kottu"
        ));

        foodList.add(new Food(
                "Chicken Noodles",
                "Rs. 990",
                R.drawable.chickennoodles,
                "Noodles"
        ));

        foodList.add(new Food(
                "Chili Noodles",
                "Rs. 750",
                R.drawable.chilinoodles,
                "Noodles"
        ));

        foodList.add(new Food(
                "Mixed Noodles",
                "Rs. 1200",
                R.drawable.mixednoodles,
                "Noodles"
        ));

        foodList.add(new Food(
                "Veg Noodles",
                "Rs. 600",
                R.drawable.vegnoodles,
                "Noodles"
        ));

        filterFood.clear();
        filterFood.addAll(foodList);
    }
    private void filterByCategory(String category) {

        filterFood.clear();

        for (Food food : foodList) {
            if (food.getCategory().equals(category)) {
                filterFood.add(food);
            }
        }

        adapter.notifyDataSetChanged();
    }


}