package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    private List<Item> dataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.myTextView);
            textView.setBackgroundColor(new Random().nextInt());

        }
    }

    public ItemAdapter(List<Item> dataset){
        this.dataset = dataset;
    }

    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Item item = dataset.get(position);
        holder.textView.setText(item.name);
        holder.textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Context context = v.getContext();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("firstName", item.firstName);
                intent.putExtra("lastName", item.lastName);
                intent.putExtra("imageUrl", item.imageUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return dataset.size();
    }
}
