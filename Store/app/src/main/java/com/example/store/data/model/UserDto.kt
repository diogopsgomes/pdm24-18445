package com.example.store.data.model

import com.example.store.domain.model.User

data class UserDto (
    val email: String,
    val name: String,
    val sharedCart: Boolean,
) {
    constructor() :  this("","",false)

    fun toUser(id: String): User {
        return User(id,email,name,sharedCart)
    }
}