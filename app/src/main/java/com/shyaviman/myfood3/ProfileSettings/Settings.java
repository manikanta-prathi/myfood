package com.shyaviman.myfood3.ProfileSettings;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shyaviman.myfood3.SplashLoginRegister.Home;
import com.shyaviman.myfood3.R;

public class Settings extends AppCompatActivity {
    TextView et_uname,et_phoneNum,et_mailId;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    private DatabaseReference userIdRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        et_uname = findViewById(R.id.tvusername);
        et_phoneNum=findViewById(R.id.tvphonenumber);

      //   et_mailId.setText(mAuth.getCurrentUser().getEmail());
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
    }

    public void logout(View view) {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Logout?").setTitle("Logout");

        builder.setMessage("Do You Want To Logout?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth.signOut();
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Logout");
        alertDialog.show();
    }
}
