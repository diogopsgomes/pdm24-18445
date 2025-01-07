package com.example.store.data.model

import com.example.store.domain.model.ProductShow
import com.example.store.domain.model.CartProduct

data class CartProductDto(
    val productId: String,
    val quantity: Int,
    val price: Double
) {
    constructor() :  this("",0,0.0)

    fun toCartProduct(id: String): CartProduct {
        return CartProduct(id, productId, quantity, price)
    }

    fun toProductShow(name: String, imageUrl: String, priceShow: Double ): ProductShow {
        return ProductShow(productId, name, imageUrl, quantity, priceShow, priceShow * quantity)
    }
}