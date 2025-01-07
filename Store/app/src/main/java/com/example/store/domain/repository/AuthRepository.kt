package com.example.store.domain.repository

import com.example.store.domain.model.UserAuth

interface AuthRepository {
    suspend fun signIn(email: String, password: String): UserAuth
    suspend fun signUp(email: String, password: String): UserAuth
    fun signOut()
    fun getCurrentUser(): UserAuth?
}