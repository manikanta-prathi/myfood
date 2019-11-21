package com.shyaviman.myfood3.VALib;
/*
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ArticlesDisplayableAdapter extends RecyclerView.Adapter<ArticlesDisplayableAdapter.ArticlesDisplayableInfo> {
    Context context;
    RecyclerView rv;
   // ArrayList<ArticlesDisplayableModel> arrayList = new ArrayList<>();
    //private ImageView imagesA;
  //  private TextView ingredients,step1,step2,step3,step4,step5,step6,title;


  //  public ArticlesDisplayableAdapter(Context context, RecyclerView rv) {
      //  this.context = context;
        //this.rv = rv;
    //}

    @NonNull
    @Override
    public ArticlesDisplayableInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.articles_displaysble_row,viewGroup,false);
        return new ArticlesDisplayableInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesDisplayableInfo articlesDisplayableInfo, int i) {
       Intent intent = ((Activity) context).getIntent();
        String images1 = intent.getStringExtra(IMAGESA);
        String ingredients = intent.getStringExtra(INGRIDIENTS);
        String step1a = intent.getStringExtra(STEP1);
        String step2a = intent.getStringExtra(STEP2);
        String step3a = intent.getStringExtra(STEP3);
        String step4a = intent.getStringExtra(STEP4);
        String step5a = intent.getStringExtra(STEP5);
        String step6a = intent.getStringExtra(STEP6);
        String  titleA= intent.getStringExtra(TITLE);
     Picasso.with(context).load(images1).placeholder(R.drawable.loading).into(articlesDisplayableInfo.imagesA);
        articlesDisplayableInfo.ingredients.setText(ingredients);
        articlesDisplayableInfo.step1.setText(step1a);
        articlesDisplayableInfo.step2.setText(step2a);
        articlesDisplayableInfo.step3.setText(step3a);
        articlesDisplayableInfo.step4.setText(step4a);
        articlesDisplayableInfo.step5.setText(step5a);
        articlesDisplayableInfo.step6.setText(step6a);
        articlesDisplayableInfo.title.setText(titleA);*/
 /*   }

    @Override
    public int getItemCount() {
        //return arrayList.size();
   // }

  //  public class ArticlesDisplayableInfo extends RecyclerView.ViewHolder {
        TextView title,ingredients,step1,step2,step3,step4,step5,step6;
        ImageView imagesA;

        public ArticlesDisplayableInfo(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.articles_title);
            ingredients = itemView.findViewById(R.id.ingr_desc);
            step1 = itemView.findViewById(R.id.steps1);
            step2 = itemView.findViewById(R.id.steps2);
            step3 = itemView.findViewById(R.id.steps3);
            step4 = itemView.findViewById(R.id.steps4);
            step5 = itemView.findViewById(R.id.steps5);
            step6 = itemView.findViewById(R.id.steps6);
            imagesA = itemView.findViewById(R.id.images1);
        }
    }
}

*/