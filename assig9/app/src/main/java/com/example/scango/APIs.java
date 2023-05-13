package com.example.scango;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {

    String BASE_URL="https://searchinapi.ml/api/v2/";

    @GET("products")
    Call<ProductResult> getProducts();

}


