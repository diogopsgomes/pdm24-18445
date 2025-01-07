package com.example.store.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.data.model.CartProductDto
import com.example.store.data.repository.CartRepositoryImpl
import com.example.store.data.repository.ProductRepositoryImpl
import com.example.store.data.repository.UserRepositoryImpl
import com.example.store.domain.model.Product
import com.example.store.domain.model.ProductShow
import com.example.store.domain.model.User
import com.example.store.domain.usecase.CartUseCase
import com.example.store.domain.usecase.ProductUseCase
import com.example.store.domain.usecase.UserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CartViewModel: ViewModel() {
    private val userRepository = UserRepositoryImpl()
    private val userUseCase = UserUseCase(userRepository)

    private val productRepository = ProductRepositoryImpl()
    private val productUseCase = ProductUseCase(productRepository)

    private val cartRepository = CartRepositoryImpl()
    private val cartUseCase = CartUseCase(cartRepository)

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    private val _productsCart = MutableStateFlow<List<CartProductDto>>(emptyList())

    @OptIn(ExperimentalCoroutinesApi::class)
    val productsCart: StateFlow<List<ProductShow>> = _productsCart
        .flatMapLatest { productsCart ->
            val flow = productsCart.map { productCart ->
                productUseCase.getProductByIdFlow(productCart.productId)
                    .map { product ->
                        productCart.toProductShow(product.name, product.imageUrl, product.price)
                    }
            }

            combine(flow) { it.toList() }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        getProducts()
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
                    _productsCart.value = products
                }
        }
    }

    suspend fun fetchUser(email: String?): User? {
        return email?.let {
            userUseCase.getUserByEmail(it)
        }
    }
}