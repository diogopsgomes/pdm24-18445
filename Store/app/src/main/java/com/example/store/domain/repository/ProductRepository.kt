package com.example.store.domain.repository

import com.example.store.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun observeProducts(): Flow<List<Product>>
    fun getProducts(): Flow<List<Product>>
    fun getProductByIdFlow(id: String): Flow<Product>
    suspend fun getProductById(id: String): Product?
}