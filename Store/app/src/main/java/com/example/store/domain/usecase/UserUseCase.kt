package com.example.store.domain.usecase

import com.example.store.data.repository.UserRepositoryImpl
import com.example.store.domain.model.User
import kotlinx.coroutines.flow.Flow

class UserUseCase(private val repository: UserRepositoryImpl) {
    fun getUsersSharedCart(): Flow<List<User>>{
        return repository.getUsersSharedCart()
    }

    suspend fun getUserByEmail(email: String): User? {
        try {
            return repository.getUserByEmail(email)
        } catch(ex: Exception){
            return null
        }
    }

    suspend fun addUser(user: User): Boolean {
        return repository.addUser(user)
    }

    suspend fun toggleCartShare(user: User, userId: String): Boolean {
        return repository.toggleCartShare(user, userId)
    }
}