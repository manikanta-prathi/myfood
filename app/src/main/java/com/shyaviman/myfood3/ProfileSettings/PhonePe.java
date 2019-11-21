package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shyaviman.myfood3.R;

public class PhonePe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_pe);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("phonepe");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
