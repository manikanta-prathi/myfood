package com.shyaviman.myfood3.ProfileSettings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shyaviman.myfood3.R;

public class Feedback extends AppCompatActivity {
TextView feedback;
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        feedback = findViewById(R.id.feedback_txt);
        editText = findViewById(R.id.edit_feedback);
    }

    public void onclick(View view) {
        Toast.makeText(this, "thanks for your feedback", Toast.LENGTH_SHORT).show();
        editText.setText(null);
    }
}
