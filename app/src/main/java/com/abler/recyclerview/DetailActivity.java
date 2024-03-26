package com.abler.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView price_tv = findViewById(R.id.mPrice);
        TextView discount_tv = findViewById(R.id.mDiscount);
        TextView overview_tv = findViewById(R.id.mDescription_tv);
        TextView stock_tv = findViewById(R.id.mStock);
        TextView brand_tv = findViewById(R.id.mBrand);
        TextView category_tv = findViewById(R.id.mCategory);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String mTitle = bundle.getString("title");
            String mRating = bundle.getString("rating");
            String mPrice = bundle.getString("price");
            String mDiscount = bundle.getString("discount");
            String mDescription = bundle.getString("description");
            String mStock = bundle.getString("stock");
            String mBrand = bundle.getString("brand");
            String mCategory = bundle.getString("category");

            title_tv.setText(mTitle);
            rating_tv.setText(mRating);
            price_tv.setText(mPrice);
            stock_tv.setText(mStock);
            brand_tv.setText(mBrand);
            category_tv.setText(mCategory);
            overview_tv.setText(mDescription);
            discount_tv.setText(mDiscount);
        }
    }
}