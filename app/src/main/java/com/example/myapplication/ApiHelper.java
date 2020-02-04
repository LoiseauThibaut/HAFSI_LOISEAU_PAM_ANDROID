package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    static final String BASE_URL = "https://api.myjson.com/";
    private ItemApi itemApi;

    /**
     * Url called : https://api.myjson.com/bins/11pw2g
     *
     * @return
     */
    public ItemApi getItemApi() {
        return itemApi;
    }

    private ApiHelper() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        itemApi = retrofit.create(ItemApi.class);
    }

    private static volatile ApiHelper instance;


    public static synchronized ApiHelper getInstance() {
        if (instance == null) {
            instance = new ApiHelper();
        }
        return instance;
    }
}