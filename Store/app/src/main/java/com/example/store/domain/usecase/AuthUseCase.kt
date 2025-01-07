package com.example.store.domain.usecase

import com.example.store.domain.model.UserAuth
import com.example.store.domain.repository.AuthRepository

class AuthUseCase(private  val repository: AuthRepository) {
    suspend fun signIn(email: String, password: String): UserAuth {
        return repository.signIn(email, password)
    }

    suspend fun signUp(email: String, password: String): UserAuth {
        return repository.signUp(email, password)
    }

    suspend fun signOut() {
        repository.signOut()
    }

    suspend fun getCurrentUser(): String? {
        val user: UserAuth? = repository.getCurrentUser()
        if (user == null)
            return ""
        else
            return user.email
    }
}