package com.alan.retoandroidalan.core.model

data class CoreResult<Result>(
    var exception: Exception? = null,
    var entity: Result? = null
)