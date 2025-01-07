package com.example.store.data.repository

import com.example.store.data.remote.FirebaseAuthentication
import com.example.store.domain.model.UserAuth
import com.example.store.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {
    override suspend fun signIn(email: String, password: String): UserAuth {
        val result = FirebaseAuthentication.signIn(email, password)
        return UserAuth(email = result.user?.email ?: "")
    }

    override suspend fun signUp(email: String, password: String): UserAuth {
        val result = FirebaseAuthentication.signUp(email, password)
        return UserAuth(email = result.user?.email ?: "")
    }

    override fun signOut() {
        FirebaseAuthentication.signOut()
    }

    override fun getCurrentUser(): UserAuth? {
        val email = FirebaseAuthentication.getCurrentUser()
        return if (email != null) UserAuth(email) else null
    }
}