package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shyaviman.myfood3.R;

public class GuidetoMyFood extends AppCompatActivity {
    TextView edit_suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideto_my_food);
        edit_suggestion = findViewById(R.id.edit_suggestion);


    }

    public void suggestion(View view) {
        Toast.makeText(this, "thank you giving valuable suggestion", Toast.LENGTH_SHORT).show();
        edit_suggestion.setText(null);
    }
}
