package com.alan.retoandroidalan.features.user.login.domain.interactor

import com.alan.retoandroidalan.R
import com.alan.retoandroidalan.core.callback.InitSessionRepository
import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.user.login.model.SessionResponseFromResult

class LoginInteractor(
    private val initSessionRepository: InitSessionRepository
) {
    suspend fun initSession(user: String, password: String): CoreResult<String> {
        return initSessionRepository.initSession(user, password)
    }

    fun getSessionFromResult(result: CoreResult<String>): SessionResponseFromResult {
        val entity = result.entity
        val exception = mapErrorExceptions(result.exception)
        val isSuccess = entity.isNullOrEmpty() && exception != null
        return SessionResponseFromResult(exception, isSuccess)
    }

    private fun mapErrorExceptions(exception: Exception?): Int? {
        return when(exception){
            is Exception -> R.string.impossible_init_session
            null -> null
            else -> R.string.unknown_error
        }
    }
}