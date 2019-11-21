package com.shyaviman.myfood3.OptionMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shyaviman.myfood3.ProfileSettings.Payment;
import com.shyaviman.myfood3.R;

public class Cart extends AppCompatActivity {
    TextView tv_value,tv_location,time,tv_totalItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent intent = getIntent();
        tv_value = findViewById(R.id.value);
        tv_location = findViewById(R.id.cyl);
        time = findViewById(R.id.etime);
        tv_totalItems=findViewById(R.id.tItems);
        Intent intent1 = getIntent();
        String price = getIntent().getStringExtra("key");
        String rtime = getIntent().getStringExtra("key1");
        String items = getIntent().getStringExtra("key2");
        time.setText(rtime);
        tv_value.setText(price);
        tv_totalItems.setText(items);
        tv_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cart.this, "saved your location", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void corder(View view) {
        Intent i = new Intent(this, Payment.class);
        startActivity(i);
        Toast.makeText(this, "saved your order", Toast.LENGTH_SHORT).show();


    }
}
