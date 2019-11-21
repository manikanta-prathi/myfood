package com.shyaviman.myfood3.Items;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyaviman.myfood3.OptionMenu.Cart;
import com.shyaviman.myfood3.Model.ItemsModel;
import com.shyaviman.myfood3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.shyaviman.myfood3.Items.Items.EXTRA_CREATOR;
import static com.shyaviman.myfood3.Items.Items.EXTRA_URL;
import static com.shyaviman.myfood3.Items.Items.PRICE;

public class ItemsRestaurent extends AppCompatActivity {
    int count = 0, cost = 40;
    TextView tv_price;
    RecyclerView rvIR;
    TextView tv_count, tv_cost;
    int total;
    ArrayList<ItemsModel> arrayList;
    ImageView imageView;
    TextView text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_restaurent);
        rvIR = findViewById(R.id.rvIR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolber);
        toolbar.setTitle("item");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_count = findViewById(R.id.tv_num);
        tv_price = findViewById(R.id.tv_prize);
        tv_cost = findViewById(R.id.cost);
        imageView = findViewById(R.id.imageView);
        text = findViewById(R.id.text);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
          String price = intent.getStringExtra(PRICE);

        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.loading).
                fit().centerInside().into(imageView);
        text.setText(creatorName);
        tv_cost.setText(price);

    }

    public void btn_plus(View view) {
        count++;
        tv_price.setText("" + (count * cost));
        tv_count.setText("" + count);
        total = Integer.parseInt(tv_price.getText().toString());
    }

    public void btn_minus(View view) {

        count--;
        tv_price.setText("" + count);
        tv_count.setText("" + count);
    }


    public void addToCart(View view) {
        Intent i = new Intent(this, Cart.class);
        String total = tv_price.getText().toString();
        String tnums = tv_count.getText().toString();
        String time = "14min";
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("key", total);
        i.putExtra("key1", time);
        i.putExtra("key2", tnums);
        startActivity(i);
        finish();
    }


}
