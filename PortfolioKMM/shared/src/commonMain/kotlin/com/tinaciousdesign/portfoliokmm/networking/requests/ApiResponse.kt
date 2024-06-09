package com.tinaciousdesign.portfoliokmm.networking.requests

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val data: T
)