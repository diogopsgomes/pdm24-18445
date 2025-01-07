package com.example.store.data.model

import com.example.store.domain.model.UserAuth

data class UserAuthDto(
    val email: String?
) {
    fun toUser(): UserAuth {
        return UserAuth(this.email)
    }
}