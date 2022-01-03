package com.izelkayacik.hizligeliyotest.model

data class ProductModel (

    //@SerializedName("id")
    val id: Int,

    //@SerializedName("title")
    val title: String,

    //@SerializedName("price")
    val price: Float,

    //@SerializedName("description")
    val description: String,

    //@SerializedName("category")
    val category: String,

    //@SerializedName("image")
    val image: String,

    //@SerializedName("rating")
    val rating: RateModel

)