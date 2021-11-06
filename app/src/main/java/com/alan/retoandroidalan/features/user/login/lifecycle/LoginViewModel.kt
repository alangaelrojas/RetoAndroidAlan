package com.alan.retoandroidalan.features.user.login.lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alan.retoandroidalan.core.BaseViewModel
import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.user.login.domain.interactor.LoginInteractor
import kotlinx.coroutines.launch

class LoginViewModel(
    private val interactor: LoginInteractor
) : BaseViewModel() {

    val flowState by lazy { MutableLiveData<LoginFlowState>() }

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
        setFlowState(LoginFlowState.OnLoginSuccess)
    }

    private fun setFlowState(_flowState: LoginFlowState){
        flowState.value = _flowState
    }

    sealed class LoginFlowState {
        object OnLoginSuccess: LoginFlowState()
    }
}