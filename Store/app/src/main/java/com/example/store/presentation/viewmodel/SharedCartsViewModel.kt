package com.example.store.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.repository.UserRepositoryImpl
import com.example.store.domain.model.User
import com.example.store.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedCartsViewModel(): ViewModel() {
    private val userRepository = UserRepositoryImpl()
    private val userUseCase = UserUseCase(userRepository)

    private val _sharedCarts = MutableStateFlow<List<User>>(emptyList())
    val sharedCarts: StateFlow<List<User>> get() = _sharedCarts

    var user = mutableStateOf("")

    init {
        getUsersSharedCart()
    }

    private fun getUsersSharedCart() {
        viewModelScope.launch {
            userUseCase.getUsersSharedCart()
                .collect { users ->
                    _sharedCarts.value = users
                }
        }
    }
}