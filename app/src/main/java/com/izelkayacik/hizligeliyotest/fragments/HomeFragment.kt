package com.izelkayacik.hizligeliyotest.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.izelkayacik.hizligeliyotest.view.MainActivity
import com.izelkayacik.hizligeliyotest.R
import com.izelkayacik.hizligeliyotest.service.Retrofit
import com.izelkayacik.hizligeliyotest.adapter.ProductItemAdapter
import com.izelkayacik.hizligeliyotest.model.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var rvProducts : RecyclerView
    private var productModels: ArrayList<ProductModel>? = null
    private lateinit var productItemAdapter : ProductItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvProducts = view.findViewById<RecyclerView>(R.id.rvProducts)
        loadData()

        return view

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

                        productItemAdapter = ProductItemAdapter(productModels!!, MainActivity.ctx )
                        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(
                            MainActivity.ctx , 2)
                        rvProducts.layoutManager = layoutManager
                        rvProducts.adapter = productItemAdapter

                        for(productModel : ProductModel in productModels!!){

                            println(productModel.id)
                            Log.e("test",productModel.id.toString())
                            Log.e("test2",productModel.title.toString())

                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {


        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}