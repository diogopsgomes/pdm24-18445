package com.example.store.domain.repository

import com.example.store.data.model.CartProductDto
import com.example.store.domain.model.CartProduct
import com.example.store.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun getCartProduct(product: Product, idUser: String): CartProduct?
    suspend fun getCartProductQuantity(product: CartProductDto, userId: String): Int?
    suspend fun addProductToCart(product: CartProductDto, userId: String): Boolean
    suspend fun removeCartProduct(product: CartProduct, userId: String): Boolean
    suspend fun addProductQuantity(product: CartProduct, userId: String): Boolean
    suspend fun subProductQuantity(product: CartProduct, userId: String): Boolean
    suspend fun isProductInCart(product: CartProductDto, userId: String): CartProduct?
    fun getCartProducts(userId: String): Flow<List<CartProduct>>
    fun observeCartProducts(userId: String): Flow<List<CartProductDto>>
}