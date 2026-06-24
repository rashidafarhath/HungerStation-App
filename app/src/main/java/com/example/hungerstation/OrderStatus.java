package com.example.hungerstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderStatus extends AppCompatActivity {

    String status = "Pending";
    TextView statusUpdate;
    Button btnnextStatus, btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_status);


        statusUpdate=findViewById(R.id.statusUpdate);
        btnnextStatus=findViewById(R.id.btnnextStatus);
        btnMenu=findViewById(R.id.btnMenu);

        statusUpdate.setText("Order Status: Pending");

        btnnextStatus.setOnClickListener(v -> {

            if (status.equals("Pending")) {

                status = "Preparing";
                statusUpdate.setText("Order Status: Preparing");

            } else if (status.equals("Preparing")) {

                status = "Completed";
                statusUpdate.setText("Order Status: Completed");

                btnnextStatus.setEnabled(false);
                btnnextStatus.setAlpha(0.5f);
                btnnextStatus.setText("Completed");

            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
                finish();
            }
        });

    }
}