package com.example.store.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.store.data.repository.AuthRepositoryImpl
import com.example.store.data.repository.UserRepositoryImpl
import com.example.store.domain.model.UserAuth
import com.example.store.domain.model.User
import com.example.store.domain.usecase.AuthUseCase
import com.example.store.domain.usecase.UserUseCase
import com.example.store.utils.AuthState
import com.example.store.utils.showToast

class SignUpViewModel: ViewModel() {
    private val authRepository = AuthRepositoryImpl()
    private val authUseCase = AuthUseCase(authRepository)

    private val userRepository = UserRepositoryImpl()
    private val userUseCase = UserUseCase(userRepository)

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    var email = mutableStateOf("")
    var password = mutableStateOf("")
    var name = mutableStateOf("")

    suspend fun signUp(email: String, password: String, context: Context): UserAuth? {
        var user: UserAuth? = null

        try {
            user = authUseCase.signUp(email,password)
        } catch (e: Exception) {
            _authState.value = AuthState.Error(e.message!!)
        }

        if (user != null) {
            showToast(context, "Registado com sucesso!")
            _authState.value = AuthState.Authenticated
            return user
        } else {
            showToast(context, "Dados inválidos!")
            _authState.value = AuthState.Unauthenticated
            return null
        }
    }

    suspend fun addUser(email: String, nome: String) {
        val user: User = User("",email,nome,false)
        if (!userUseCase.addUser(user)) _authState.value = AuthState.Error("Erro ao registar utilizador!")
    }
}