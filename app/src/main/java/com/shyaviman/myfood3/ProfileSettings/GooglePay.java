package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shyaviman.myfood3.R;

public class GooglePay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_pay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("google pay");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
