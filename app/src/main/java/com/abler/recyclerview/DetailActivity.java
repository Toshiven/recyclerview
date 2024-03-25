package com.abler.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.movervie_tv);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String mTitle = bundle.getString("title");
            String mRating = bundle.getString("rating");
            String mPrice = bundle.getString("price");
            String mDiscount = bundle.getString("discount");

            title_tv.setText(mTitle);
            rating_tv.setText(mRating);
            overview_tv.setText("Price: " + mPrice + "\nDiscount Percentage: " + mDiscount);
        }
    }
}