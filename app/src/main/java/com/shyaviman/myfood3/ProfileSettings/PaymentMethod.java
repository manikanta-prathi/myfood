package com.shyaviman.myfood3.ProfileSettings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.shyaviman.myfood3.R;

public class PaymentMethod extends AppCompatActivity {
    TextView t1_card,t2_paytm,t3_googlepay,t4_phonepe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        t1_card=findViewById(R.id.card);
        t2_paytm=findViewById(R.id.paytm);
        t3_googlepay=findViewById(R.id.googlepay);
        t4_phonepe=findViewById(R.id.phonepe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("payment method");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        t1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardintent = new Intent(PaymentMethod.this,CreditorDebitCard.class);
                startActivity(cardintent);
            }
        });
        t2_paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paytmintent = new Intent(PaymentMethod.this,Paytm.class);
                startActivity(paytmintent);
            }
        });
        t3_googlepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googlepayintent = new Intent(PaymentMethod.this,GooglePay.class);
                startActivity(googlepayintent);
            }
        });
        t4_phonepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phonepeintent = new Intent(PaymentMethod.this,PhonePe.class);
                startActivity(phonepeintent);
            }
        });
    }
    }

