package com.shyaviman.myfood3.Nearby.RestaurentsItems;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.NonVeg_Item.EXTRA_CREATORVN;
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.NonVeg_Item.EXTRA_URLVN;
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.NonVeg_Item.IMAGESVN;
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.VegItem.EXTRA_CREATOR1;
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.VegItem.EXTRA_URL1;
import static com.shyaviman.myfood3.Nearby.RestaurentsItems.VegItem.IMAGES;

public class RestaurentNearby extends AppCompatActivity {

    int count = 0, cost = 70;
    TextView tv_price,title;
    RecyclerView rvIR;
    TextView tv_count, tv_cost;
    int total;
    ImageView images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent_nearby);
        rvIR = findViewById(R.id.rvIR);
        tv_count = findViewById(R.id.tv_numN);
        tv_price = findViewById(R.id.tv_prizeN);
        tv_cost = findViewById(R.id.costN);
        title =findViewById(R.id.textN);
        images = findViewById(R.id.images_I);
        Intent intent = getIntent();
        String price = intent.getStringExtra(EXTRA_URL1);
        String title1 = intent.getStringExtra(EXTRA_CREATOR1);
        String imagesurl =intent.getStringExtra(IMAGES);
        String namesNV = intent.getStringExtra(EXTRA_URLVN);
        String priceNV = intent.getStringExtra(EXTRA_CREATORVN);
        String  imagesurlNV = intent.getStringExtra(IMAGESVN);
        Picasso.with(this)
                .load(imagesurlNV)
                .placeholder(R.drawable.loading).
                fit().centerInside().into(images);
        title.setText(priceNV);
        tv_cost.setText(namesNV);
        title.setText(price);
        tv_cost.setText(title1);
        Picasso.with(this)
                .load(imagesurl)
                .placeholder(R.drawable.loading).
                fit().centerInside().into(images);


    }
    public void btn_plusN(View view) {
        count++;
        tv_price.setText("" + count * cost);
        tv_count.setText("" + count);
        total = Integer.parseInt(tv_price.getText().toString());
    }

    public void btn_minusN(View view) {
if (count>0) {
    count--;
    tv_price.setText("" + count);
    tv_count.setText("" + count);

}
        }



    public void addToCartN(View view) {
        Intent i = new Intent(this, Cart.class);
        String total = tv_price.getText().toString();
        String tnums=tv_count.getText().toString();
        String time ="14min";
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("key",total);
        i.putExtra("key1",time);
        i.putExtra("key2",tnums);
        startActivity(i);
        finish();
    }
}
