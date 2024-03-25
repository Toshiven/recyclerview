package com.abler.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.abler.recyclerview.Product;
import com.abler.recyclerview.ProductAdapter;
import com.abler.recyclerview.R;
import com.abler.recyclerview.VolleySingleton;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        productList = new ArrayList<>();
        fetchProducts();
    }

    private void fetchProducts() {
        String url = "https://dummyjson.com/products?fbclid=IwAR0ZQuqRqofVQffA_lE4Xrb1keEujIkEsRYoDtSs1YQIr_1u_Y5HLp6AeAU";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject productJson = response.getJSONObject(i);
                                String title = productJson.getString("title");
                                int price = productJson.getInt("price");
                                double discountPercentage = productJson.getDouble("discountPercentage");
                                double rating = productJson.getDouble("rating");

                                Product product = new Product(title, price, discountPercentage, rating);
                                productList.add(product);
                            }

                            ProductAdapter adapter = new ProductAdapter(MainActivity.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}
