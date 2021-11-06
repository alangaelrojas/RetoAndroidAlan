package com.alan.retoandroidalan.features.user.login.model

import androidx.annotation.StringRes

data class SessionResponseFromResult(
    @StringRes val error: Int?,
    val success: Boolean
)