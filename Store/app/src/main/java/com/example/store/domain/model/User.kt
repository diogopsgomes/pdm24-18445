package com.example.store.domain.model

data class User(
    val id: String,
    val email: String,
    val name: String,
    val sharedCart: Boolean,
) {
    constructor(): this("","","",false)
}