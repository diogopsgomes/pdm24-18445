package com.example.store.data.repository

import com.example.store.domain.model.Product
import com.example.store.domain.repository.ProductRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class ProductRepositoryImpl: ProductRepository {
    private val db: FirebaseFirestore = Firebase.firestore

    override fun observeProducts(): Flow<List<Product>> = callbackFlow {
        val listenerRegistration = db.collection("products")
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                if (querySnapshot != null) {
                    val products = querySnapshot.documents.mapNotNull { it.toObject(Product::class.java) }
                    trySend(products)
                }
            }
        awaitClose { listenerRegistration.remove() }
    }

    override fun getProducts() = db.collection("products").snapshots().map { Snapshot ->
        Snapshot.documents.mapNotNull { document ->
            val product = document.toObject(Product::class.java)
            product?.copy(id = document.id)
        }
    }

    override fun getProductByIdFlow(id: String): Flow<Product> = callbackFlow {
        val documentRef = db.collection("products").document(id)
        val listener = documentRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                close(error)
                return@addSnapshotListener
            }
            snapshot?.toObject(Product::class.java)?.let { product ->
                trySend(product).isSuccess
            }
        }
        awaitClose { listener.remove() }
    }

    override suspend fun getProductById(id: String): Product? {
        try {
            val productDocument = db.collection("products").document(id).get().await()

            return productDocument.toObject(Product::class.java)?.copy(id = productDocument.id)
        } catch (e: Exception) {
            return null
        }
    }
}