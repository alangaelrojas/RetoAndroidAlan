package com.alan.retoandroidalan.features.tasks.list.lifecycle

import androidx.lifecycle.viewModelScope
import com.alan.retoandroidalan.core.BaseViewModel
import com.alan.retoandroidalan.core.BaseViewModel.BaseFlowState.*
import com.alan.retoandroidalan.features.tasks.list.domain.interactor.ListTasksInteractor
import kotlinx.coroutines.launch

class ListTasksViewModel(
    private val listTasksInteractor: ListTasksInteractor
) : BaseViewModel() {

    fun getListTasksForUser(){
        viewModelScope.launch {
            setFlowState(OnLoading)
            val result = listTasksInteractor.getTasksForUser("")

        }
    }
}