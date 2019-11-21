package com.shyaviman.myfood3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.shyaviman.myfood3.Items.Items;
import com.shyaviman.myfood3.Nearby.Nearby;
import com.shyaviman.myfood3.OptionMenu.Notification;
import com.shyaviman.myfood3.OptionMenu.Cart;
import com.shyaviman.myfood3.ProfileSettings.Profile;
import com.shyaviman.myfood3.SplashLoginRegister.Home;
import com.shyaviman.myfood3.VALib.Library;

public class Navigation extends AppCompatActivity {
    BottomNavigationView mMainNav;
    FrameLayout mMainFrames;
    FirebaseAuth mAuth;
    AlertDialog.Builder builder;

    Nearby nearbyFragment;
    Items itemsFragment;
    Library libraryFragments;
    Profile profilFragmetns;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mMainNav = findViewById(R.id.main_nav);
        nearbyFragment = new Nearby();
        itemsFragment = new Items();
        libraryFragments = new Library();
        profilFragmetns = new Profile();
        builder = new AlertDialog.Builder(this);
        setFragment(nearbyFragment);
        mAuth = FirebaseAuth.getInstance();

        mMainFrames = findViewById(R.id.main_frame);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_nearby:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(nearbyFragment);
                        return true;
                    case R.id.navigation_items:

                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(itemsFragment);
                        return true;
                    case R.id.navigation_library:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(libraryFragments);
                        return true;

                    case R.id.navigation_profile:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(profilFragmetns);
                        return true;


                    default:
                        return false;

                }

            }


        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);

        fragmentTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.notification) {


            startActivity(new Intent(this, Notification.class));

        } else if (id == R.id.cart) {
            startActivity(new Intent(this, Cart.class));

        } else if (id == R.id.logout) {
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

        return super.onOptionsItemSelected(item);


    }
}













