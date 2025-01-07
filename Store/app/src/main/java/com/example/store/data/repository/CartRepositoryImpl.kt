package com.example.store.data.repository

import com.example.store.data.model.CartProductDto
import com.example.store.domain.model.CartProduct
import com.example.store.domain.model.Product
import com.example.store.domain.repository.CartRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class CartRepositoryImpl: CartRepository {
    private val db: FirebaseFirestore = Firebase.firestore

    override suspend fun getCartProduct(product: Product, idUser: String): CartProduct? {
        try {
            val query = db.collection("users")
                .document(idUser)
                .collection("cart")
                .whereEqualTo("productId", product.id)
                .get()
                .await()

            val document = query.documents.firstOrNull()

            document?.let {
                val cartProductDto = it.toObject(CartProductDto::class.java)
                return cartProductDto?.toCartProduct(it.id)
            }

            return null
        } catch (ex: Exception) {
            return null
        }
    }

    override suspend fun getCartProductQuantity(product: CartProductDto, userId: String): Int? {
        try {
            val document = db.collection("users")
                .document(userId)
                .collection("cart")
                .document(product.productId)
                .get()
                .await()

            return document.getLong("quantity")?.toInt()
        } catch (ex: Exception) {
            return null
        }
    }

    override suspend fun addProductToCart(product: CartProductDto, userId: String): Boolean {
        try {
            val documentId = db.collection("users")
                .document(userId)
                .collection("cart")
                .add(product)
                .await()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun removeCartProduct(product: CartProduct, userId: String): Boolean {
        try {
            val document = db.collection("users")
                .document(userId)
                .collection("cart")
                .document(product.id)
                .delete()
                .await()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun addProductQuantity(product: CartProduct, userId: String): Boolean {
        try {
            val document = db.collection("users")
                .document(userId)
                .collection("cart")
                .document(product.id)

            document.update("quantity", product.quantity + 1).await()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun subProductQuantity(product: CartProduct, userId: String): Boolean {
        try {
            val document = db.collection("users")
                .document(userId)
                .collection("cart")
                .document(product.id)

            document.update("quantity", product.quantity - 1).await()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun isProductInCart(product: CartProductDto, userId: String): CartProduct? {
        try {
            val documentId = db.collection("users")
                .document(userId)
                .collection("cart")
                .whereEqualTo("productId", product.productId)
                .get()
                .await()

            val prod = documentId.documents.firstOrNull()?.toObject(CartProductDto::class.java)
            if(prod == null) return null

            return CartProduct(documentId.documents.firstOrNull()!!.id, prod.productId, prod.quantity, prod.price)
        } catch (e: Exception) {
            return null
        }
    }

    override fun getCartProducts(userId: String) =
        db.collection("users")
            .document(userId)
            .collection("cart")
            .snapshots()
            .map { Snapshot ->
                Snapshot.documents.mapNotNull { document ->
                    val prod = document.toObject(CartProductDto::class.java)

                    prod?.toCartProduct(document.id)
                }
            }

    override fun observeCartProducts(userId: String): Flow<List<CartProductDto>> = callbackFlow {
        val listenerRegistration = db.collection("users").document(userId).collection("cart")
            .addSnapshotListener { querySnapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }
                if (querySnapshot != null) {
                    val products = querySnapshot.documents.mapNotNull { it.toObject(CartProductDto::class.java) }
                    trySend(products)
                }
            }
        awaitClose { listenerRegistration.remove() }
    }
}