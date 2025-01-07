package com.example.store.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.store.data.repository.AuthRepositoryImpl
import com.example.store.domain.model.UserAuth
import com.example.store.domain.usecase.AuthUseCase
import com.example.store.utils.AuthState
import com.example.store.utils.showToast

class SignInViewModel: ViewModel() {
    private val authRepository = AuthRepositoryImpl()
    private val authUseCase = AuthUseCase(authRepository)

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        _authState.value = AuthState.Unauthenticated
    }

    var email = mutableStateOf("")
    var password = mutableStateOf("")

    suspend fun signIn(email: String, password: String, context: Context): UserAuth? {
        var user: UserAuth? = null

        try {
            user = authUseCase.signIn(email,password)
        } catch (e: Exception) {
            _authState.value = AuthState.Error(e.message!!)
        }

        if (user != null) {
            showToast(context, "Autenticado com sucesso!")
            _authState.value = AuthState.Authenticated
            return user
        } else {
            showToast(context, "Credenciais inválidas!")
            _authState.value = AuthState.Unauthenticated
            return null
        }
    }
}