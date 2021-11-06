package com.alan.retoandroidalan.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _flowState by lazy { MutableLiveData<BaseFlowState>() }
    val baseFlowState: MutableLiveData<BaseFlowState> = _flowState

    fun setFlowState(flowState: BaseFlowState){
        baseFlowState.value = flowState
    }

    sealed class BaseFlowState {
        object OnLoading : BaseFlowState()
        data class OnError(val error: Int) : BaseFlowState()
    }

}