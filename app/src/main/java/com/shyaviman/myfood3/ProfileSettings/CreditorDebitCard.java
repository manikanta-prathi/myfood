package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shyaviman.myfood3.R;

public class CreditorDebitCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditor_debit_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("credit or debit card");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
