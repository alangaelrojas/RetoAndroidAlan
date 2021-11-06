package com.alan.retoandroidalan.core.implementations

import com.alan.retoandroidalan.core.callback.InitSessionRepository
import com.alan.retoandroidalan.core.model.CoreResult
import com.google.firebase.auth.FirebaseAuth

class InitSessionImpl: InitSessionRepository {

    override suspend fun initSession(email: String, password: String): CoreResult<String> {
        val result = CoreResult<String>()
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnSuccessListener {
            result.entity = it.user?.uid
        }.addOnFailureListener {
            result.exception = Exception()
        }
        return result
    }

    override suspend fun signOut(): CoreResult<Boolean> {
        val result = CoreResult<Boolean>()
        try {
            FirebaseAuth.getInstance().signOut()
            result.entity = true
        } catch (e: Exception){
            result.exception = e
        }
        return result
    }
}