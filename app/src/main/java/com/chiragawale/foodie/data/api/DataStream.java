package com.chiragawale.foodie.data.api;

import android.os.AsyncTask;
import android.util.Log;

public class DataStream{
    private static final String API_ENDPOINT = "https://api.edamam.com/api/food-database/parser";
    public String getFoodData(String foodName){
        HttpRequest request = new HttpRequest();
        String url = API_ENDPOINT +
                "?ingr="+ foodName +
                "&app_id=" + Configuration.getAPP_ID() +
                "&app_key=" + Configuration.getAPI_KEY();
        String result = "";
        try {
            result = request.execute(url).get();
        } catch (Exception e){}
        //Log.e("RESULT", result);
        return result;
    }


}
