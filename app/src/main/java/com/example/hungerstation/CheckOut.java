package com.example.hungerstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckOut extends AppCompatActivity {

    ImageView back;
    TextView placeorder;
    EditText custName, custNum, custAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_out);

        back=findViewById(R.id.back);
        placeorder=findViewById(R.id.placeorder);
        custName=findViewById(R.id.custName);
        custNum=findViewById(R.id.custNum);
        custAdd=findViewById(R.id.custAdd);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Cart.class);
                startActivity(intent);
                finish();
            }
        });

//        placeorder.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(getApplicationContext(), OrderStatus.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        placeorder.setOnClickListener(v -> {

            String name = custName.getText().toString().trim();
            String phone = custNum.getText().toString().trim();
            String address = custAdd.getText().toString().trim();

            if (name.isEmpty()) {
                custName.setError("Name is required");
                custName.requestFocus();
                return;
            }

            if (phone.isEmpty()) {
                custNum.setError("Phone number is required");
                custNum.requestFocus();
                return;
            }

            if (address.isEmpty()) {
                custAdd.setError("Address is required");
                custAdd.requestFocus();
                return;
            }

            CartManager.cartItems.clear();

            Intent intent= new Intent(getApplicationContext(), OrderStatus.class);
            startActivity(intent);
            finish();
        });

    }
}