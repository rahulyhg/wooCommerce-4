package com.example.annie.woocommerce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.annie.woocommerce.adapter.CategoryDataAdapter;
import com.example.annie.woocommerce.model.Category;
import com.example.annie.woocommerce.model.ProductCategory;
import com.example.annie.woocommerce.model.ProductCategoryResponse;
import com.example.annie.woocommerce.service.WooCommerceService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryList extends AppCompatActivity {
    RecyclerView categoryListView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        categoryListView=(RecyclerView)findViewById(R.id.recycler_view_category_list);
       // categoryListView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        categoryListView.setLayoutManager(layoutManager);
        final List<Category> categoryList= new ArrayList<>();



        WooCommerceService service = ServiceGenerator.createService(WooCommerceService.class);
        Call<ProductCategoryResponse>ListCategoryResponseCall= service.getListCategory();
        ListCategoryResponseCall.enqueue(new Callback<ProductCategoryResponse>() {
            @Override
            public void onResponse(Call<ProductCategoryResponse> call, Response<ProductCategoryResponse> response) {

                ProductCategoryResponse CategoryResponse=response.body();
                Log.d("Debug", String.valueOf(CategoryResponse.getProductCategories().size()));
                List<ProductCategory>productCategories=CategoryResponse.getProductCategories();
                adapter = new CategoryDataAdapter(CategoryList.this,productCategories);
                categoryListView.setAdapter(adapter);
                categoryListView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<ProductCategoryResponse> call, Throwable t) {

            }
        });

    }
}

