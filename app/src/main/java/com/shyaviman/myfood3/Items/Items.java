package com.shyaviman.myfood3.Items;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.shyaviman.myfood3.Model.ItemsModel;
import com.shyaviman.myfood3.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Items extends Fragment implements ItemsAdapter.OnItemClickListener {
    RecyclerView rvI;
    ArrayList<ItemsModel> arrayList;
    public static final String EXTRA_URL = "imageLinks";
    public static final String EXTRA_CREATOR = "title";
    public static final String PRICE = "price";

    private RequestQueue mRequestQueue;
    ProgressDialog loading;

    public Items() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items, container, false);
        rvI = v.findViewById(R.id.rcI);
        rvI.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        loading = new ProgressDialog(getContext());
        loading.show();
        loading.setCancelable(false);
        loading.setMessage("please wait...");
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolber);
        toolbar.setTitle("food items");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvI.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvI.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        return v;

    }

    private void parseJSON() {

        String url = "https://myfood1234.000webhostapp.com/items.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loading.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("restaurents");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject items = jsonArray.getJSONObject(i);
                        String images = items.optString("imageLinks");
                        String title = items.optString("title");
                        String  price = items.getString("price");
                        ItemsModel itemsModel = new ItemsModel(images, title,price);
                        itemsModel.setTitle(title);
                        itemsModel.setImages(images);
                        arrayList.add(itemsModel);


                    }
                    ItemsAdapter itemsAdapter = new ItemsAdapter(getContext(), arrayList);
                    itemsAdapter.setOnItemClickListener(Items.this);
                    rvI.setAdapter(itemsAdapter);
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
        Intent deatailedIntent = new Intent(getContext(), ItemsRestaurent.class);
        ItemsModel itemsModel = arrayList.get(position);
        deatailedIntent.putExtra(EXTRA_URL, itemsModel.getImages());
        deatailedIntent.putExtra(EXTRA_CREATOR, itemsModel.getTitle());
        deatailedIntent.putExtra(PRICE, itemsModel.getPrice());

        startActivity(deatailedIntent);

    }

}
