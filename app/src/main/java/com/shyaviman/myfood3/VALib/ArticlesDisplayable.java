package com.shyaviman.myfood3.VALib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyaviman.myfood3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.shyaviman.myfood3.VALib.Artcles.IMAGESA;
import static com.shyaviman.myfood3.VALib.Artcles.INGRIDIENTS;
import static com.shyaviman.myfood3.VALib.Artcles.STEP1;
import static com.shyaviman.myfood3.VALib.Artcles.STEP2;
import static com.shyaviman.myfood3.VALib.Artcles.STEP3;
import static com.shyaviman.myfood3.VALib.Artcles.STEP4;
import static com.shyaviman.myfood3.VALib.Artcles.STEP5;
import static com.shyaviman.myfood3.VALib.Artcles.STEP6;
import static com.shyaviman.myfood3.VALib.Artcles.TITLE;

public class ArticlesDisplayable extends AppCompatActivity {
   // RecyclerView rv_articles;
  //  ArrayList<ArticlesDisplayableModel> arrayList;
   ImageView images_disp;
   TextView title_disp,ingredients_disp,step1_disp,step2_disp,step3_disp,step4_disp,step5_disp,step6_disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_displayable);
        images_disp = findViewById(R.id.images_displayable);
        title_disp = findViewById(R.id.title_displayable);
        ingredients_disp=findViewById(R.id.ingredients_displyable);
        step1_disp = findViewById(R.id.steps1);
        step2_disp= findViewById(R.id.steps2);
        step3_disp= findViewById(R.id.steps3);
        step4_disp= findViewById(R.id.steps4);
        step5_disp= findViewById(R.id.steps5);
        step6_disp= findViewById(R.id.steps6);
        Intent intent = getIntent();
        String images1 = intent.getStringExtra(IMAGESA);
        String title1 = intent.getStringExtra(TITLE);
        String ingredietns=intent.getStringExtra(INGRIDIENTS);
        String  step1=intent.getStringExtra(STEP1);
        String  step2=intent.getStringExtra(STEP2);
        String  step3=intent.getStringExtra(STEP3);
        String  step4=intent.getStringExtra(STEP4);
        String  step5=intent.getStringExtra(STEP5);
        String  step6=intent.getStringExtra(STEP6);
        Picasso.with(this)
                .load(images1)
                .placeholder(R.drawable.loading).
                fit().centerInside().into(images_disp);
        title_disp.setText(title1);
        ingredients_disp.setText(ingredietns);
        step1_disp.setText(step1);
        step2_disp.setText(step2);
        step3_disp.setText(step3);
        step4_disp.setText(step4);
        step5_disp.setText(step5);
        step6_disp.setText(step6);


     //   rv_articles = findViewById(R.id.da_rv);
       // arrayList = new ArrayList<>();
      //  rv_articles.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       // ArticlesDisplayableAdapter articlesDisplayableAdapter = new ArticlesDisplayableAdapter(getApplicationContext(),rv_articles);
      //  rv_articles.setAdapter(articlesDisplayableAdapter);
    }
}
