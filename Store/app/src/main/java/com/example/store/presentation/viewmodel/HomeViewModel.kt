package com.example.store.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.model.CartProductDto
import com.example.store.data.repository.AuthRepositoryImpl
import com.example.store.data.repository.CartRepositoryImpl
import com.example.store.data.repository.ProductRepositoryImpl
import com.example.store.data.repository.UserRepositoryImpl
import com.example.store.domain.model.Product
import com.example.store.domain.model.ProductShow
import com.example.store.domain.model.User
import com.example.store.domain.usecase.AuthUseCase
import com.example.store.domain.usecase.CartUseCase
import com.example.store.domain.usecase.ProductUseCase
import com.example.store.domain.usecase.UserUseCase
import com.example.store.utils.showToast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val authRepository = AuthRepositoryImpl()
    private val authUseCase = AuthUseCase(authRepository)

    private val productRepository = ProductRepositoryImpl()
    private val productUseCase = ProductUseCase(productRepository)

    private val userRepository = UserRepositoryImpl()
    private val userUseCase = UserUseCase(userRepository)

    private val cartRepository = CartRepositoryImpl()
    private val cartUseCase = CartUseCase(cartRepository)

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    private val _cartProducts = MutableStateFlow<List<CartProductDto>>(emptyList())

    var cartProducts: StateFlow<List<ProductShow>> = _cartProducts
        .flatMapLatest { cartProducts ->
            val flow = cartProducts.map { cartProduct ->
                productUseCase.getProductByIdFlow(cartProduct.productId)
                    .map { product ->
                        cartProduct.toProductShow(product.name, product.imageUrl, product.price)
                    }
            }

            combine(flow) {it.toList()}
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        getProducts()
    }

    fun clearCart() {
        _cartProducts.value = emptyList()
    }

    suspend fun signOut() {
        try {
            authUseCase.signOut()
        } catch (e: Exception) {
            throw IllegalArgumentException(e.message)
        }
    }

    suspend fun toggleCartShare(email: String, context: Context){
        val user = userUseCase.getUserByEmail(email)

        if (user != null) {
            if (!userUseCase.toggleCartShare(user, user.id)) {
                showToast(context, "Erro ao partilhar carrinho!")
            } else {
                showToast(context, "Carrinho ${if (!user.sharedCart) "" else "não "}partilhado!")
            }
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            productUseCase.getProducts()
                .collect { products ->
                    _products.value = products
                }
        }
    }

    fun observeCart(id: String) {
        viewModelScope.launch {
            cartUseCase.observeCartProducts(id)
                .collect { products ->
                    _cartProducts.value = products
                }
        }
    }

    suspend fun fetchUser(email: String?): User? {
        return email?.let {
            userUseCase.getUserByEmail(it)
        }
    }

    suspend fun addProductToCart(product: Product, userId: String, context: Context) {
        cartUseCase.addProductToCart(product, userId)
        showToast(context, "Produto adicionado!")
    }

    suspend fun removeCartProduct(product: Product, userId: String, context: Context) {
        cartUseCase.removeCartProduct(product, userId)
        showToast(context, "Produto removido!")
    }
}