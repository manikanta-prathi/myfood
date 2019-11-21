package com.shyaviman.myfood3.ProfileSettings;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shyaviman.myfood3.OptionMenu.Cart;
import com.shyaviman.myfood3.ProfileSettings.Help.Help1;
import com.shyaviman.myfood3.SplashLoginRegister.Home;
import com.shyaviman.myfood3.OptionMenu.Notification;
import com.shyaviman.myfood3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {
    TextView t2_pay,t3_help,t4_share,t5_settings,t6_feedback,t7_about;
Context context;

    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v = inflater.inflate(R.layout.fragment_profile, container, false);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolber);
        toolbar.setTitle("profile");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        t2_pay=v.findViewById(R.id.payment);
        t3_help=v.findViewById(R.id.help1);
        t4_share=v.findViewById(R.id.share);
        t5_settings=v.findViewById(R.id.settings);
        t6_feedback=v.findViewById(R.id.feedback);
        t7_about=v.findViewById(R.id.about);

        t2_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent payIntent = new Intent(getContext(), Payment.class);
                startActivity(payIntent);
            }
        });
        t3_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = new Intent(getContext(), Help1.class);
                startActivity(helpIntent);
            }
        });
        t4_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = "https://drive.google.com/open?id=1NmplHGr_r5OpT4HKtJycjlxxEvgryg-Y";
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder.from((Activity)getContext()).setType(mimeType).setChooserTitle("share")
                        .setText(txt)
                        .startChooser();
            }
        });
        t5_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingIntent = new Intent(getContext(), Settings.class);
                startActivity(settingIntent);
            }
        });
        t6_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackIntent = new Intent(getContext(), Feedback.class);
                startActivity(feedbackIntent);
            }
        });
        t7_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutIntent = new Intent(getContext(), About.class);
                startActivity(aboutIntent);
            }
        });


        return  v;


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
