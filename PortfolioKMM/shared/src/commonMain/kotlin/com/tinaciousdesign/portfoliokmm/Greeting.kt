package com.tinaciousdesign.portfoliokmm

import com.tinaciousdesign.portfoliokmm.networking.ApiClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * This is no longer used in the project.
 * @deprecated
 */
class Greeting : KoinComponent {
    private val platform by inject<Platform>()
    private val apiClient by inject<ApiClient>()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun ktorDocs(): String {
        val response = apiClient.getTechnologies()
        return response.toString()
//        val response = client.get("https://ktor.io/docs/welcome.html")
//        return response.bodyAsText()
    }
}