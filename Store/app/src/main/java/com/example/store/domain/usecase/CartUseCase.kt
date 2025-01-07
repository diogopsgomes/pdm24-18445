package com.example.store.domain.usecase

import com.example.store.data.model.CartProductDto
import com.example.store.data.repository.CartRepositoryImpl
import com.example.store.domain.model.Product
import com.example.store.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

class CartUseCase(private val repository: CartRepositoryImpl) {
    suspend fun addProductToCart(product: Product, id: String): Boolean {
        val newProduct = CartProductDto(product.id, 1, product.price)
        val cartProduct = isProductInCart(newProduct, id)

        if (cartProduct != null) {
            return repository.addProductQuantity(cartProduct, id)
        } else {
            return repository.addProductToCart(newProduct, id)
        }
    }

    suspend fun removeCartProduct(product: Product, idUser: String): Boolean {
        val cartProduct =  repository.getCartProduct(product, idUser)

        if (cartProduct != null) {
            if (cartProduct.quantity > 1) {
                repository.subProductQuantity(cartProduct, idUser)
            } else {
                repository.removeCartProduct(cartProduct, idUser)
            }

            return true
        } else {
            return false
        }
    }

    suspend fun isProductInCart(product: CartProductDto, id: String): CartProduct? {
        return repository.isProductInCart(product, id)
    }

    fun getCartProducts(id: String): Flow<List<CartProduct>> {
        return repository.getCartProducts(id)
    }

    fun observeCartProducts(id: String): Flow<List<CartProductDto>> {
        return repository.observeCartProducts(id)
    }
}