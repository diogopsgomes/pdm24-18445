package com.example.store.domain.model

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String
) {
    constructor(): this("","",0.0,"")
}