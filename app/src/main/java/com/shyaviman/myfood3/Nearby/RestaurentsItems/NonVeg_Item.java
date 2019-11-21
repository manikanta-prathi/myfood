package com.shyaviman.myfood3.Nearby.RestaurentsItems;

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
import com.shyaviman.myfood3.Items.ItemRestaurentAdapter;

import com.shyaviman.myfood3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NonVeg_Item extends Fragment implements ItemRestaurentAdapter.OnItemClickListener {


    private RecyclerView rvIR;
    ArrayList<NonVegItemModel> arrayList;
    public static final String EXTRA_URLVN = "title";
    public static final String EXTRA_CREATORVN = "price";
    public  static final String IMAGESVN="imagelinks";
    private RequestQueue mRequestQueue;

    public NonVeg_Item() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_non_veg__item, container, false);
        rvIR = v.findViewById(R.id.rvIR);
        rvIR.setHasFixedSize(true);
        arrayList = new ArrayList<NonVegItemModel>();
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();


        rvIR.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    private void parseJSON() {
        String url = "https://myfood1234.000webhostapp.com/nonvegitems.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("food_items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject items = jsonArray.getJSONObject(i);
                        String title = items.optString("title");
                        String prize = items.optString("prize");
                        String images = items.optString( "imagelinks");
                        NonVegItemModel nonVegItemModel = new NonVegItemModel(title, prize,images);
                        nonVegItemModel.setNames(title);
                        nonVegItemModel.setPrice(prize);
                        nonVegItemModel.setImages(images);
                        arrayList.add(nonVegItemModel);
                    }
                    ItemRestaurentAdapter itemRestaurentAdapter = new ItemRestaurentAdapter(getContext(),arrayList);
                    itemRestaurentAdapter.setOnItemClickListener(NonVeg_Item.this);
                    rvIR.setAdapter(itemRestaurentAdapter);




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
    @Override
    public void onItemClick(int position) {
        Intent deatailedIntent = new Intent(getContext(), RestaurentNearby.class);
        NonVegItemModel nonVegItemModel = arrayList.get(position);
        deatailedIntent.putExtra(EXTRA_URLVN, nonVegItemModel.getNames());
        deatailedIntent.putExtra(EXTRA_CREATORVN, nonVegItemModel.getPrice());
        deatailedIntent.putExtra(IMAGESVN,nonVegItemModel.getImages());
        startActivity(deatailedIntent);

    }


}
