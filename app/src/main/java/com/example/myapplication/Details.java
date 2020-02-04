package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends Activity {
    TextView textView;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        // Find the different elements of this activity
        textView = findViewById(R.id.detailText);
        imageView = findViewById(R.id.image);

        // Get the intent to have data from the main activity
        Intent intent = getIntent();

        // Get the data for the TextView
        String data = "First Name : ";
        data += intent.getStringExtra("firstName");
        data += "\nLast Name : ";
        data += intent.getStringExtra("lastName");

        // Update the TextView
        textView.setText(data);

        String url = intent.getStringExtra("imageUrl");
        if(url == null){
            url = "https://cdn4.iconfinder.com/data/icons/political-elections/50/48-512.png";
        }

        // Update the ImageView
        Picasso.with(getBaseContext()).load(url).into(imageView);
    }
}
