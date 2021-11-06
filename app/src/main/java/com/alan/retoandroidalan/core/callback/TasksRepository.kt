package com.alan.retoandroidalan.core.callback

import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.tasks.list.domain.model.TasksDomainModel

interface TasksRepository {
    suspend fun getListTasksForUser(userId: String): CoreResult<TasksDomainModel>
    suspend fun deleteTask(tasksId: String): CoreResult<Boolean>
}