package com.alan.retoandroidalan.core.implementations

import com.alan.retoandroidalan.core.callback.TasksRepository
import com.alan.retoandroidalan.core.model.CoreResult
import com.alan.retoandroidalan.features.tasks.list.domain.model.TasksDomainModel

class TasksImpl : TasksRepository {

    override suspend fun getListTasksForUser(userId: String): CoreResult<TasksDomainModel> {
        TODO("List tasks")
    }

    override suspend fun deleteTask(tasksId: String): CoreResult<Boolean> {
        TODO("TODO: Delete task")
    }
}