package com.shyaviman.myfood3.SplashLoginRegister;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shyaviman.myfood3.Navigation;
import com.shyaviman.myfood3.R;

public class Register extends AppCompatActivity {
    private static final String CHANNEL_ID = "shya vi man";
    private static final String CHANNEL_NAME = "shya vi man";
    private static final String CHANNEL_DESC = "shya vi man notification";
    EditText et_mail, et_pswd, et_phone, et_rpswd, et_user;
    Button btn_register;
    private ProgressDialog RegisterDialog;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    private DatabaseReference userIdRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        et_mail = findViewById(R.id.etEmail);
        et_pswd = findViewById(R.id.etPswd);
        et_phone = findViewById(R.id.etnum);
        et_user = findViewById(R.id.etuser);
        et_rpswd = findViewById(R.id.etRpswd);
        btn_register = findViewById(R.id.btnRegister);
        RegisterDialog = new ProgressDialog(this);
        RegisterDialog.setMessage("Registering...");
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager nManager = getSystemService(NotificationManager.class);
            nManager.createNotificationChannel(channel)
            ;

        }


        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                register();

            }
        });
    }

    public void register() {
        RegisterDialog.show();

         final String phone = et_phone.getText().toString().trim();

         final String user = et_user.getText().toString().trim();

         final String emailId = et_mail.getText().toString().trim();
        String cPswd = et_pswd.getText().toString().trim();
        String rPswd = et_rpswd.getText().toString().trim();

        if (user.isEmpty()) {
            et_user.setError("your name is required");
            et_user.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            et_phone.setError("phone number is required");
            et_phone.requestFocus();
            return;
        }
        if (!Patterns.PHONE.matcher(phone).matches()) {
            et_phone.setError("please enter a valid phone number");
            et_phone.requestFocus();
        }
        if (emailId.isEmpty()) {
            et_mail.setError("email is required");
            et_mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            et_mail.setError("please enter a valid email address");
            et_mail.requestFocus();
        }
        if (cPswd.isEmpty()) {
            et_pswd.setError("create your password");
            et_pswd.requestFocus();
            return;
        }
        if (cPswd.length() < 6) {
            et_pswd.setError("please create a password for more than 6");
            et_pswd.requestFocus();
        }
        if (rPswd.isEmpty()) {
            et_rpswd.setError("re-enter  your password");
            et_rpswd.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailId, cPswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    RegisterDialog.dismiss();
                    Toast.makeText(Register.this, "user register successfull ", Toast.LENGTH_SHORT).show();
                   userIdRef = databaseReference.child(mAuth.getCurrentUser().getUid());
                   userIdRef.child("name").setValue(user);
                   userIdRef.child("phone").setValue(phone);

                    Intent i = new Intent(getApplicationContext(), Navigation.class);
                    startActivity(i);

                    displayNotification();

                } else {
                    RegisterDialog.dismiss();
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void displayNotification() {

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("MyFood")
                .setContentText("Successfully Registered on myfood...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationmngr = NotificationManagerCompat.from(this);
        notificationmngr.notify(1, mBuilder.build());


    }
}



