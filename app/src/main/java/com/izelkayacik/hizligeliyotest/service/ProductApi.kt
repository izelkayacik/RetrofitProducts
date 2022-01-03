package com.izelkayacik.hizligeliyotest.service

import com.izelkayacik.hizligeliyotest.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    //https://fakestoreapi.com/products

    @GET("products")
    fun getData(): Call<List<ProductModel>>
}