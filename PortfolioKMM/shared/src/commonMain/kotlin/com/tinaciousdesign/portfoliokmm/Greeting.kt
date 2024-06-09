package com.tinaciousdesign.portfoliokmm

import com.tinaciousdesign.portfoliokmm.networking.ApiClient

class Greeting {
    private val platform: Platform = getPlatform()
//    private val client = HttpClient()
    private val apiClient = ApiClient()

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