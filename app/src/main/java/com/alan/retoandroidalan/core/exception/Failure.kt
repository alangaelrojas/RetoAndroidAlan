package com.alan.retoandroidalan.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object NotFoundError : Failure()
    object UnAuthorizedError

    abstract class FeatureFailure : Failure()
}
