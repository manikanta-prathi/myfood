package com.shyaviman.myfood3.ProfileSettings.Help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.shyaviman.myfood3.ProfileSettings.AccountandPaymentOptions;
import com.shyaviman.myfood3.ProfileSettings.GuidetoMyFood;
import com.shyaviman.myfood3.ProfileSettings.PastOrders;
import com.shyaviman.myfood3.R;


public class Help1 extends AppCompatActivity {

    TextView tv_pastorders, tv_accsetting, tv_guidmyfood,lastOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help1);

        tv_accsetting = findViewById(R.id.accandpay);
        tv_guidmyfood = findViewById(R.id.guidmyfood);
        lastOrders =findViewById(R.id.last_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("Help");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lastOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LastOrders.class));
            }
        });


        tv_accsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accsettingintent = new Intent(Help1.this, AccountandPaymentOptions.class);
                startActivity(accsettingintent);
            }
        });

        tv_guidmyfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guidintent = new Intent(Help1.this, GuidetoMyFood.class);
                startActivity(guidintent);
            }
        });

    }
}
