package com.example.store.domain.model

data class ProductShow (
    var id: String,
    var name: String,
    var imageUrl: String,
    var quantity: Int,
    var price: Double,
    var total: Double
) {
    constructor(): this("","","",0,0.0,0.0)
}