package com.example.myapplication;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
    public MutableLiveData<List<Item>> items;

    public LiveData<List<Item>> getItems(){
        if(items == null){
            items = new MutableLiveData<>();
            loadItems();
        }
        return items;
    }

    public void loadItems(){
        ApiHelper.getInstance().getItemApi().getItem("6szby").enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response){
                if(response.isSuccessful()){
                    items.setValue(response.body());
                } else {
                    Log.e(null, response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t){
                t.printStackTrace();
            }
        });

    }
}
