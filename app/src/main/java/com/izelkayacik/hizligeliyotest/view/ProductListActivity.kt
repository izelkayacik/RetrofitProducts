package com.izelkayacik.hizligeliyotest.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izelkayacik.hizligeliyotest.R
import com.izelkayacik.hizligeliyotest.service.Retrofit
import com.izelkayacik.hizligeliyotest.adapter.ProductItemAdapter
import com.izelkayacik.hizligeliyotest.model.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListActivity : AppCompatActivity() {

    lateinit var rvProducts : RecyclerView
    private var productModels: ArrayList<ProductModel>? = null
    private lateinit var productItemAdapter : ProductItemAdapter
    lateinit var ctx : Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        ctx = this;

        rvProducts = findViewById<RecyclerView>(R.id.rvProducts)

        loadData()

    }

    private fun loadData(){

        Retrofit.getClient().getData().enqueue(object: Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ){
                if(response.isSuccessful){
                    response.body()?.let {
                        productModels = ArrayList(it)

                        productItemAdapter = ProductItemAdapter(productModels!!, ctx )
                        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(ctx , 2)
                        rvProducts.layoutManager = layoutManager
                        rvProducts.adapter = productItemAdapter

                        for(productModel : ProductModel in productModels!!){

                            println(productModel.id)

                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}