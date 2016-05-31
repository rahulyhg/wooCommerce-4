package com.example.annie.woocommerce;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by SONY on 5/31/2016.
 */
public class BasicAuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder=chain.request().newBuilder();
        String username="ck_28a7212b64b111281e823bfb3449b04cc7323cf0";
        String password="cs_10348c9efd5611f713c19911c913909859226160";
        String credentials =username+":"+password;
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        requestBuilder.addHeader("Authorization", basic);
        return chain.proceed(requestBuilder.build());
    }
    }

