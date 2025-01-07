package com.example.store.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.repository.AuthRepositoryImpl
import com.example.store.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {
    private val authRepository: AuthRepositoryImpl = AuthRepositoryImpl();
    private val authUseCase: AuthUseCase = AuthUseCase(authRepository)

    private val _isAuthenticated = MutableStateFlow<String?>("")
    val isAuthenticated: StateFlow<String?> get() = _isAuthenticated

    init {
        viewModelScope.launch {
            isUserAuthenticated()
        }
    }

    suspend fun isUserAuthenticated() {
        _isAuthenticated.value = authUseCase.getCurrentUser()
    }
}