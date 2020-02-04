package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemApi {

    /**
     * Call a webservice with dynamic path
     * Exemple :
     * "https://api.myjson.com/bins/31245"
     * base url : https://api.myjson.com/
     * path : bins/{id}
     * where id = 31245
     * So the method will be called using getNews("31235");
     */

    @GET("bins/{id}")
    Call<List<Item>> getItem(@Path("id") String id);

}