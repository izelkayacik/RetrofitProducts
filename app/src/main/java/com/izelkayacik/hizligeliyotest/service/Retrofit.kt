package com.izelkayacik.hizligeliyotest.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class Retrofit {

    companion object{
        private val BASE_URL = "https://fakestoreapi.com/"

        fun getClient(): ProductApi {

            var retro : Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retro.create(ProductApi::class.java)

            return retro.create(ProductApi::class.java)

        }

    }



}