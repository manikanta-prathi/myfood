package com.shyaviman.myfood3.ProfileSettings;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.shyaviman.myfood3.R;


public class Payment extends AppCompatActivity {
    TextView t1_payment,t2_cash,t3_paymethods;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Toolbar toolbar = findViewById(R.id.toolber);
        setSupportActionBar(toolbar);
        toolbar.setTitle("payment");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t1_payment = findViewById(R.id.payment);
        t2_cash = findViewById(R.id.cash);
        t3_paymethods=findViewById(R.id.paymentmethods);
        t2_cash=findViewById(R.id.cash);
        mAuth=FirebaseAuth.getInstance();
        t2_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cashintent = new Intent(Payment.this, Cash.class);
                startActivity(cashintent);
            }
        });
        t3_paymethods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payintent = new Intent(Payment.this, PaymentMethod.class);
                startActivity(payintent);
            }
        });
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                NavUtils.navigateUpFromSameTask(Payment.this);
            }
        });

    }


}

