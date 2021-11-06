package com.alan.retoandroidalan.core.callback

import com.alan.retoandroidalan.core.model.CoreResult

interface InitSessionRepository {
    suspend fun initSession(email: String, password: String): CoreResult<String>
    suspend fun signOut(): CoreResult<Boolean>
}