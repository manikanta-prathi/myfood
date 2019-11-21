package com.shyaviman.myfood3.VALib;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class FetchArticlesDisplayable extends AsyncTask<String, Void, String> {
    private static final String url = "https://myfood1234.000webhostapp.com/articles.json";
    ProgressDialog loading;
    Context context;
    RecyclerView rv;
    String title,ingredients,step1,step2,step3,step4,step5,step6,images;

    ArrayList<ArticlesDisplayableModel> arrayList = new ArrayList<>();

    public FetchArticlesDisplayable(Context context, RecyclerView rv) {
        this.context = context;
        this.rv = rv;
    }

    @Override
    protected String doInBackground(String...strings) {
        try {

            URL u = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            if (inputStream != null) {
                InputStreamReader inputStreamData = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(inputStreamData);
                String line = null;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);

                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = new ProgressDialog(context);
        loading.show();
        loading.setMessage("please wait...");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loading.dismiss();
        if (s!=null){
            try {
                JSONObject rootObject = new JSONObject(s);
                JSONArray jsonArray = rootObject.getJSONArray( "food_items");
                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject items = jsonArray.getJSONObject(i);
                    title =items.optString(   "title");
                    ingredients=items.getString(    "ingredient_desc");
                    step1=items.getString(  "step1");
                    step2=items.getString( "step2");
                    step3=items.getString(  "step3");
                    step4=items.getString( "step4");
                    step5=items.getString(  "step5");
                    step6=items.getString(  "step6");
                    images=items.getString(  "images");

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

               // ArticlesDisplayableAdapter articlesDisplayableAdapter = new  ArticlesDisplayableAdapter(context,arrayList);
               // rv.setAdapter(articlesDisplayableAdapter);
                rv.setLayoutManager(new LinearLayoutManager(context));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
