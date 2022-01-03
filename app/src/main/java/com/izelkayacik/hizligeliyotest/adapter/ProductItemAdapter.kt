package com.izelkayacik.hizligeliyotest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.izelkayacik.hizligeliyotest.R
import com.izelkayacik.hizligeliyotest.model.ProductModel

class ProductItemAdapter(private val productList: ArrayList<ProductModel> , private val ctx : Context) : RecyclerView.Adapter<ProductItemAdapter.RowHolder>() {


    class RowHolder (view: View) : RecyclerView.ViewHolder(view) {
        val productImage : AppCompatImageView = view.findViewById(R.id.imgProduct)
        val productName : TextView = view.findViewById(R.id.txtProductName)
        val productPrice : TextView = view.findViewById(R.id.txtProductPrice)
        val productPriceOld : TextView = view.findViewById(R.id.txtProductPriceOld)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_view, parent, false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val currentProduct : ProductModel = productList[position]


        Glide.with(ctx).load(currentProduct.image).into(holder.productImage)
        /*holder.productName.text = currentProduct.title
        holder.productPrice.text = currentProduct.price*/

        currentProduct.title.let{ it ->
            holder.productName.text = it
        }?: run {
            holder.productName.text = "Ürün adı yok"
        }

        currentProduct.price.let{ it ->
            holder.productPrice.text = it.toString()
        }?: run {
            holder.productPrice.text = "Ürün fiyatı yok"
        }



    }

    override fun getItemCount(): Int {
       return productList.size
    }




}