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
import com.shyaviman.myfood3.Items.Items;
import com.shyaviman.myfood3.Items.ItemsRestaurent;
import com.shyaviman.myfood3.Model.VegItemsModel;
import com.shyaviman.myfood3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VegItem extends Fragment implements RestaurentAdapter.OnItemClickListener {
    RecyclerView rvVeg;
    ArrayList<VegItemsModel> arrayList;
    public static final String EXTRA_URL1 = "title";
    public static final String EXTRA_CREATOR1 = "price";
    public  static final String IMAGES="imagelinks";
    private RequestQueue mRequestQueue;
    public VegItem() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_veg_item, container, false);
        rvVeg = v.findViewById(R.id.rcR);
        rvVeg.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();

        rvVeg.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    private void parseJSON() {
        String url = "https://myfood1234.000webhostapp.com/vegitems.json";
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
                        VegItemsModel vegItemsModel = new VegItemsModel(title, prize,images);
                        vegItemsModel.setTitle(title);
                        vegItemsModel.setPrice(prize);
                        vegItemsModel.setImages(images);
                        arrayList.add(vegItemsModel);
                    }
                    RestaurentAdapter restaurentAdapter = new RestaurentAdapter(getContext(), arrayList);
                    restaurentAdapter.setOnItemClickListener(VegItem.this);
                    rvVeg.setAdapter(restaurentAdapter);


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
        VegItemsModel vegItemsModel = arrayList.get(position);
        deatailedIntent.putExtra(EXTRA_URL1, vegItemsModel.getTitle());
        deatailedIntent.putExtra(EXTRA_CREATOR1, vegItemsModel.getPrice());
        deatailedIntent.putExtra(IMAGES,vegItemsModel.getImages());
        startActivity(deatailedIntent);

    }

}
