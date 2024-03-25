package com.abler.recyclerview;

import android.content.Context;
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

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = productList.get(position);

        holder.title.setText(product.getTitle());
        holder.rating.setText(product.getRating().toString());
        holder.price.setText(product.getPrice());
        holder.discountPercentage.setText(product.getDiscountPercentage().toString());
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
