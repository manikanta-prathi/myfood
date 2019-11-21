package com.shyaviman.myfood3.VALib;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.shyaviman.myfood3.Items.Items;
import com.shyaviman.myfood3.Items.ItemsRestaurent;
import com.shyaviman.myfood3.Model.ItemsModel;
import com.shyaviman.myfood3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Artcles extends Fragment implements ArtclesAdapter.OnItemClickListener {
    public static final String TITLE = "title";
    public static final String IMAGESA = "images";
    public static final String STEP1 = "step1";
    public static final String STEP2 = "step2";
    public static final String STEP3 = "step3";
    public static final String STEP4 = "step4";
    public static final String STEP5 = "step5";
    public static final String STEP6 = "step6";
    public static final String INGRIDIENTS = "ingridients";
    private RequestQueue mRequestQueue;
    ProgressDialog loading;
    RecyclerView rv_a;
    ArrayList<ArticlesDisplayableModel> arrayList;



    public Artcles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_artcles, container, false);
        rv_a = v.findViewById(R.id.rvA);
        rv_a.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        loading = new ProgressDialog(getContext());
        loading.show();
        loading.setCancelable(true);
        loading.setMessage("please wait...");
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();



        return v;
    }

    private void parseJSON() {
        String url = "https://myfood1234.000webhostapp.com/articles.json";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loading.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray( "food_items");
                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject items = jsonArray.getJSONObject(i);
                       String title =items.getString(   "title");
                        String ingredients=items.getString(    "ingredient_desc");
                        String step1=items.getString(  "step1");
                        String step2=items.getString( "step2");
                        String  step3=items.getString(  "step3");
                        String step4=items.getString( "step4");
                        String step5=items.getString(  "step5");
                        String step6=items.getString(  "step6");
                        String images=items.getString(  "images");
                        ArticlesDisplayableModel articlesDisplayableModel = new ArticlesDisplayableModel(title,ingredients,step1,step2,step3,step4,step5,step6,images);
                        articlesDisplayableModel.setTitle(title);
                        articlesDisplayableModel.setIngredients(ingredients);
                        articlesDisplayableModel.setImages(images);
                        articlesDisplayableModel.setStep1(step1);
                        articlesDisplayableModel.setStep2(step2);
                        articlesDisplayableModel.setStep3(step3);
                        articlesDisplayableModel.setStep4(step4);
                        articlesDisplayableModel.setStep5(step5);
                        articlesDisplayableModel.setStep6(step6);
                        arrayList.add(articlesDisplayableModel);
                    }
                    rv_a.setLayoutManager(new LinearLayoutManager(getContext()));
                    ArtclesAdapter artclesAdapter = new ArtclesAdapter(getContext(),arrayList);
                    artclesAdapter.setOnItemClickListener(Artcles.this);
                    rv_a.setAdapter(artclesAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
    @Override
    public void onItemClick(int position) {
        Intent deatailedIntent = new Intent(getContext(), ArticlesDisplayable.class);
        ArticlesDisplayableModel articlesDisplayableModel = arrayList.get(position);
        deatailedIntent.putExtra(TITLE, articlesDisplayableModel.getTitle());
        deatailedIntent.putExtra(IMAGESA, articlesDisplayableModel.getImages());
        deatailedIntent.putExtra(STEP1, articlesDisplayableModel.getStep1());
        deatailedIntent.putExtra(STEP2, articlesDisplayableModel.getStep2());
        deatailedIntent.putExtra(STEP3, articlesDisplayableModel.getStep3());
        deatailedIntent.putExtra(STEP4, articlesDisplayableModel.getStep4());
        deatailedIntent.putExtra(STEP5, articlesDisplayableModel.getStep5());
        deatailedIntent.putExtra(STEP6, articlesDisplayableModel.getStep6());
        deatailedIntent.putExtra(INGRIDIENTS, articlesDisplayableModel.getIngredients());
        startActivity(deatailedIntent);

    }


}
