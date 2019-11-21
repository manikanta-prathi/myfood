package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shyaviman.myfood3.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);   Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("about");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void google(View view) {
    }

    public void facebook(View view) {
    }

    public void instagram(View view) {
    }
}
