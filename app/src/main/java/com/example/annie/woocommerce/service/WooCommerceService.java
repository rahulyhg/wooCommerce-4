package com.example.annie.woocommerce.service;

import com.example.annie.woocommerce.model.ProductCategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SONY on 5/31/2016.
 */
public interface WooCommerceService {
    @GET("products/categories")
    Call<ProductCategoryResponse>getListCategory();
}
