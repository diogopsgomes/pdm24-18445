package com.example.store.domain.model

data class CartProduct(
    val id: String,
    val productId: String,
    val quantity: Int,
    val price: Double
) {
    constructor(): this("","",0,0.0)
}