package com.shyaviman.myfood3.SplashLoginRegister;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shyaviman.myfood3.Navigation;
import com.shyaviman.myfood3.R;

public class Home extends AppCompatActivity {
    EditText et_mail,et_pswd;
    TextView tv1,tv2;
    private ProgressDialog loginDialog;
    private static final String CHANNEL_ID = "shya vi man";
    private static final String CHANNEL_NAME = "shya vi man";
    private static final String CHANNEL_DESC= "shya vi man notification";
    FirebaseAuth mauth;
    ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
        mauth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        et_mail = findViewById(R.id.etMail_login);
        et_pswd = findViewById(R.id.pswd_login);
        tv1 = findViewById(R.id.register);
        tv2 = findViewById(R.id.fgtpswd);
        progressBar = findViewById(R.id.pbarlogin);
        mauth = FirebaseAuth.getInstance();
        loginDialog =new ProgressDialog(this);
        loginDialog.setMessage("Login..");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()!=null){
                    startActivity(new Intent(Home.this, Navigation.class).
                            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    finish();
                }
            }
        };




        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager nManager = getSystemService(NotificationManager.class);
            nManager.createNotificationChannel(channel)
            ;

        }
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),ForgettenPswd.class);
                startActivity(b);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent a = new Intent(v.getContext(), Register.class);
                    startActivity(a);

                }

        });
    }


    public void login(View view) {

        String mail = et_mail.getText().toString().trim();
        String pswd = et_pswd.getText().toString().trim();
        if (mail.isEmpty()) {
            et_mail.setError("email is required");
            et_mail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            et_mail.setError("please enter a valid email address");
            et_mail.requestFocus();
        }
        if (pswd.isEmpty()) {
            et_pswd.setError("create your password");
            et_pswd.requestFocus();
            return;
        }
        if (pswd.length() < 6) {
            et_pswd.setError("please create a password for more than 6");
            et_pswd.requestFocus();
        }
        loginDialog.show();
        mauth.signInWithEmailAndPassword(mail,pswd).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    loginDialog.dismiss();
                    Intent i = new Intent(Home.this,Navigation.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    displayNotification();
                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    loginDialog.dismiss();
                }
            }
        });




    }
    private void displayNotification(){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("MyFood")
                .setContentText("Successfully loged on myfood...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationmngr = NotificationManagerCompat.from(this);
        notificationmngr.notify(1,mBuilder.build());


    }
}
