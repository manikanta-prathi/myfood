package com.shyaviman.myfood3.SplashLoginRegister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shyaviman.myfood3.R;

public class ForgettenPswd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetten_pswd);
    }

    public void submit(View view) {
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
