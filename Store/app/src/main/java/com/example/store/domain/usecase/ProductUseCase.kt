package com.example.store.domain.usecase

import com.example.store.data.repository.ProductRepositoryImpl
import com.example.store.domain.model.Product
import kotlinx.coroutines.flow.Flow

class ProductUseCase(private val repository: ProductRepositoryImpl) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.observeProducts()
    }

    fun getProducts(): Flow<List<Product>> {
        return repository.getProducts()
    }

    suspend fun getProductById(id: String): Product? {
        return repository.getProductById(id)
    }

    fun getProductByIdFlow(id: String): Flow<Product> {
        return repository.getProductByIdFlow(id)
    }
}