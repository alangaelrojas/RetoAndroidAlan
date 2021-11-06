package com.alan.retoandroidalan.features.tasks.list.domain.interactor

import com.alan.retoandroidalan.core.callback.TasksRepository
import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.tasks.list.domain.model.TasksDomainModel

class ListTasksInteractor(
    private val tasksRepository: TasksRepository
) {
    suspend fun getTasksForUser(userId: String): CoreResult<TasksDomainModel>{
        return tasksRepository.getListTasksForUser(userId)
    }

}