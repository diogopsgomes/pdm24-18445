package com.example.store.domain.repository

import com.example.store.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun addUser(user: User): Boolean
    suspend fun getUserByEmail(email: String): User?
    fun getUsersSharedCart(): Flow<List<User>>
    suspend fun toggleCartShare(user: User, userId: String): Boolean
}