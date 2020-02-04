package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private MyViewModel model;
    private RecyclerView list;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.my_recycler_view);
        list.setHasFixedSize(true);
        //list.addItemDecoration(new DividerItemDecoration(list.getContext(), DividerItemDecoration.VERTICAL));

        model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getItems().observe(this, items -> {
            layout = new LinearLayoutManager(this);
            list.setLayoutManager(layout);

            adapter = new ItemAdapter(model.items.getValue());
            list.setAdapter(adapter);
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}
