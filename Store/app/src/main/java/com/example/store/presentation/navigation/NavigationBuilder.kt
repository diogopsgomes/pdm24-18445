package com.example.store.presentation.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.store.presentation.view.screens.SharedCartScreen
import com.example.store.presentation.view.screens.CartScreen
import com.example.store.presentation.view.screens.HomeScreen
import com.example.store.presentation.view.screens.SharedCartsScreen
import com.example.store.presentation.view.screens.SignInScreen
import com.example.store.presentation.view.screens.SignUpScreen
import com.example.store.presentation.view.screens.SplashScreen
import com.example.store.presentation.viewmodel.CartViewModel
import com.example.store.presentation.viewmodel.HomeViewModel
import com.example.store.presentation.viewmodel.SharedCartsViewModel
import com.example.store.presentation.viewmodel.SignInViewModel
import com.example.store.presentation.viewmodel.SignUpViewModel
import com.example.store.presentation.viewmodel.SplashViewModel
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Splash: Screen()
    @Serializable
    data object SignIn: Screen()
    @Serializable
    data object SignUp: Screen()
    @Serializable
    data class Home(
        val email: String?
    ): Screen()
    @Serializable
    data class Cart(
        val email: String?
    ): Screen()
    @Serializable
    data class SharedCarts(
        val email: String?
    ): Screen()
    @Serializable
    data class SharedCart(
        val email: String
    ): Screen()
}

@SuppressLint("RestrictedApi")
@Composable
fun SetupNavGraph(navController: NavHostController) {
    val homeViewModel: HomeViewModel = viewModel()
    val sharedCartsViewModel: SharedCartsViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash
    ) {
        composable<Screen.Splash> {
            val splashViewModel: SplashViewModel = viewModel()
            SplashScreen(splashViewModel, navController)
        }
        composable<Screen.SignIn> {
            val loginViewModel: SignInViewModel = viewModel()
            SignInScreen(navController = navController, loginViewModel)
        }
        composable<Screen.SignUp> {
            val singUpViewModel: SignUpViewModel = viewModel()
            SignUpScreen(navController = navController, singUpViewModel)
        }
        composable<Screen.Home> { backStackEntry ->
            val email = backStackEntry.toRoute<Screen.Home>()
            Log.d("Email", "Email no navGraph${email.email}")
            HomeScreen(navController = navController, homeViewModel, email.email)
        }
        composable<Screen.Cart> { backStackEntry ->
            val email = backStackEntry.toRoute<Screen.Cart>()
            CartScreen(navController = navController, homeViewModel, email.email)
        }
        composable<Screen.SharedCarts> { backStackEntry ->
            val email = backStackEntry.toRoute<Screen.SharedCarts>()
            SharedCartsScreen(navController = navController, sharedCartsViewModel, email.email)
        }
        composable<Screen.SharedCart> { backStackEntry ->
            val email = backStackEntry.toRoute<Screen.SharedCart>()
            val cartViewModel: CartViewModel = viewModel()
            SharedCartScreen(navController = navController, cartViewModel, email.email)
        }
    }
}