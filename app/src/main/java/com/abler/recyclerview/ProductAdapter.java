package com.abler.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> products){
        this.context = context;
        productList = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ProductHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = productList.get(position);

        Log.d("ProductAdapter", "Title: " + product.getTitle());
        Log.d("ProductAdapter", "Rating: " + product.getRating());
        Log.d("ProductAdapter", "Price: " + product.getPrice());
        Log.d("ProductAdapter", "Discount Percentage: " + product.getDiscountPercentage());


        holder.title.setText(product.getTitle());
        holder.rating.setText(String.valueOf(product.getRating()));
        holder.price.setText(String.valueOf(product.getPrice()));
        holder.discountPercentage.setText(String.valueOf(product.getDiscountPercentage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder{


        TextView  title,  price, discountPercentage, rating;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            rating = itemView.findViewById(R.id.rating_tv);
            price = itemView.findViewById(R.id.price_tv);
            discountPercentage = itemView.findViewById(R.id.discount_tv);
        }
    }
}
