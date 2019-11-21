package com.shyaviman.myfood3.Nearby.RestaurentsItems;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyaviman.myfood3.OptionMenu.Cart;
import com.shyaviman.myfood3.SplashLoginRegister.Home;
import com.shyaviman.myfood3.OptionMenu.Notification;
import com.shyaviman.myfood3.R;
import com.squareup.picasso.Picasso;

import static com.shyaviman.myfood3.Items.Items.EXTRA_CREATOR;
import static com.shyaviman.myfood3.Items.Items.EXTRA_URL;

public class Restaurent extends AppCompatActivity {
    ImageView imageView;
    TextView restaurent;

    ViewPager vp1;
    RestaurentAdapter restadapter;
    TabLayout tb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent);
        vp1 = findViewById(R.id.vpRest);
        tb = findViewById(R.id.tbRest);
        imageView = findViewById(R.id.imageView);
        restaurent =findViewById(R.id.titleR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("restaurent");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);

        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.loading).
                fit().centerInside().into(imageView);
        restaurent.setText(creatorName);

        restadapter = new RestaurentAdapter(getSupportFragmentManager());
        vp1.setAdapter(restadapter);

        tb.setupWithViewPager(vp1);

    }

    public class RestaurentAdapter extends FragmentStatePagerAdapter {

        public RestaurentAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new VegItem();
                case 1:
                    return new NonVeg_Item();
                default:
                    break;

            }

            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "veg";
                case 1:
                    return "non veg";


            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    // @Override
    //  protected void onCreate(Bundle savedInstanceState) {
    //   super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_restaurent);


}

