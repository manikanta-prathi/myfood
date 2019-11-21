package com.shyaviman.myfood3.Nearby;


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
import com.shyaviman.myfood3.Model.NearbyModel;
import com.shyaviman.myfood3.R;
import com.shyaviman.myfood3.Nearby.RestaurentsItems.Restaurent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nearby extends Fragment implements NearbyAdapter.OnItemClickListener {
    RecyclerView rvN;
    ProgressDialog loading;
    ArrayList<NearbyModel> arrayList;
    public static final String EXTRA_URL = "imageLinks";
    public static final String EXTRA_CREATOR = "title";
    private RequestQueue mRequestQueue;



    public Nearby() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nearby, container, false);
        rvN = v.findViewById(R.id.rvN);
        rvN.setHasFixedSize(false);
        loading = new ProgressDialog(getContext());
        loading.show();
        loading.setCancelable(true);
        loading.setMessage("please wait...");
        arrayList = new ArrayList<NearbyModel>();
        mRequestQueue = Volley.newRequestQueue(getContext());
        parseJSON();
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolber);
        toolbar.setTitle("nearby restaurents");

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            rvN.setLayoutManager(new GridLayoutManager(getContext(),1));
        } else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            rvN.setLayoutManager(new GridLayoutManager(getContext(),2));
        }

        return v;
    }


    private void parseJSON() {

        String url = "https://myfood1234.000webhostapp.com/restaurents.txt";
      JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
              loading.dismiss();
              try {


                  JSONArray jsonArray = response.getJSONArray("restaurents");
                  for (int i = 0; i < jsonArray.length(); i++) {
                      JSONObject items = jsonArray.getJSONObject(i);
                      String title = items.optString("title");
                      String location = items.optString("location");
                    String   rating = items.optString("rating");
                     String  smallthumbnail = items.optString("imageLinks");
                   NearbyModel nearbyModel = new NearbyModel(title,location,rating,smallthumbnail);
                      nearbyModel.setTitle(title);
                      nearbyModel.setLocation(location);
                      nearbyModel.setRating(rating);
                      nearbyModel.setSmallThumnail(smallthumbnail);
                      arrayList.add(nearbyModel);
                  }

                  NearbyAdapter nearbyAdapter = new NearbyAdapter(getContext(), arrayList);
                  nearbyAdapter.setOnItemClickListener(Nearby.this);
                  rvN.setAdapter(nearbyAdapter);
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
        Intent restaurents = new Intent(getContext(), Restaurent.class);
        NearbyModel nearbyModel = arrayList.get(position);
        restaurents.putExtra(EXTRA_URL, nearbyModel.getSmallThumnail());
        restaurents.putExtra(EXTRA_CREATOR, nearbyModel.getTitle());
        startActivity(restaurents);

    }


}

