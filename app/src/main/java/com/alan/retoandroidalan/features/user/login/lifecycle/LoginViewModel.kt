package com.alan.retoandroidalan.features.user.login.lifecycle

import androidx.lifecycle.viewModelScope
import com.alan.retoandroidalan.core.BaseViewModel
import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.user.login.domain.interactor.LoginInteractor
import kotlinx.coroutines.launch

class LoginViewModel(
    private val interactor: LoginInteractor
) : BaseViewModel() {

    fun initSession(user: String, password: String){
        viewModelScope.launch {
            setFlowState(BaseFlowState.OnLoading)
            val result = interactor.initSession(user, password)
            setStateFromSessionResult(result)
        }
    }

    private fun setStateFromSessionResult(result: CoreResult<String>) {
        val sessionSuccess = interactor.getSessionFromResult(result)
        if (sessionSuccess.error != null) {
            setFlowState(BaseFlowState.OnError(sessionSuccess.error))
            return
        }
        setFlowState(BaseFlowState.OnLoginSuccess)
    }
}