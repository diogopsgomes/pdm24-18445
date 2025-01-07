package com.example.store.utils

import android.content.Context
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

sealed class AuthState{
    data object Authenticated: AuthState()
    data object Unauthenticated: AuthState()
    data class Error(
        val message: String
    ): AuthState()
}

fun showToast(
    context: Context,
    message: String
) = makeText(context, message, LENGTH_LONG).show()