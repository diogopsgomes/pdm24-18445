package com.example.store.data.repository

import com.example.store.data.model.UserDto
import com.example.store.domain.model.User
import com.example.store.domain.repository.UserRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl: UserRepository {
    private val db: FirebaseFirestore = Firebase.firestore

    override suspend fun addUser(user: User): Boolean {
        try {
            val usersCollection = db.collection("users")

            usersCollection.add(user).await()

            return true
        } catch (e: Exception) {
            return false
        }
    }

    override suspend fun getUserByEmail(email: String): User? {
        try {
            val usersCollection = db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .await()

            val documentSnapshot = usersCollection.documents.firstOrNull()
            val user = documentSnapshot?.toObject(UserDto::class.java)

            return user?.toUser(documentSnapshot.id)
        } catch (ex: Exception) {
            return null
        }
    }

    override fun getUsersSharedCart(): Flow<List<User>> {
        return db.collection("users")
            .whereEqualTo("sharedCart", true)
            .snapshots()
            .map { snapshot ->
                snapshot.documents.mapNotNull { document ->
                    document.toObject(User::class.java)
                }
            }
    }

    override suspend fun toggleCartShare(user: User, userId: String): Boolean {
        try {
            val userDocument = db.collection("users").document(userId)

            userDocument.update("sharedCart", !user.sharedCart).await()

            return true
        } catch (e: Exception) {
            return false
        }
    }
}