package com.shyaviman.myfood3.VALib;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.shyaviman.myfood3.SplashLoginRegister.Home;
import com.shyaviman.myfood3.OptionMenu.Notification;
import com.shyaviman.myfood3.OptionMenu.Cart;
import com.shyaviman.myfood3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Library extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;


    public Library() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_library, container, false);
        tabLayout = v.findViewById(R.id.tbLayoutL);
        viewPager = v.findViewById(R.id.vPagerL);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolber);
        toolbar.setTitle("library");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        LAdapter adapter = new LAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    private class LAdapter extends FragmentPagerAdapter {

        public LAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new Videos();
                case 1:
                    return new Artcles();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Videos";
                case 1:
                    return "Articles";


            }
            return super.getPageTitle(position);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.notification) {


            startActivity(new Intent(getContext(), Notification.class));

        } else if (id == R.id.cart) {
            startActivity(new Intent(getContext(), Cart.class));

        }
        else if (id == R.id.logout) {
            startActivity(new Intent(getContext(), Home.class));
        }


        return super.onOptionsItemSelected(item);


    }
}
