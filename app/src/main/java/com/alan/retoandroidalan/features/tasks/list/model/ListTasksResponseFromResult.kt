package com.alan.retoandroidalan.features.tasks.list.model

import androidx.annotation.StringRes
import com.alan.retoandroidalan.features.tasks.list.domain.model.TasksDomainModel

data class ListTasksResponseFromResult(
    @StringRes val error: Int?,
    val tasks: TasksDomainModel
)