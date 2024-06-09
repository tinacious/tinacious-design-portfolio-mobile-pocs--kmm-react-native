package com.tinaciousdesign.portfoliokmm.networking

import co.touchlab.kermit.Logger
import com.tinaciousdesign.portfoliokmm.networking.requests.ApiResponse
import com.tinaciousdesign.portfoliokmm.networking.requests.GetPortfolioItems
import com.tinaciousdesign.portfoliokmm.networking.requests.GetServices
import com.tinaciousdesign.portfoliokmm.networking.requests.GetTechnologies
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import com.tinaciousdesign.portfoliokmm.networking.responses.ServiceItem
import com.tinaciousdesign.portfoliokmm.networking.responses.TechnologyItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.plugins.resources.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiClient {
    private val client = HttpClient() {
        defaultRequest {
            url("https://tinaciousdesign.com/api/")
        }
        install(Resources)
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getPortfolioItems(): Result<List<PortfolioItem>> =
        try {
            val res = client.get(GetPortfolioItems()).body<ApiResponse<List<PortfolioItem>>>()
            Result.success(res.data)
        } catch (e: Exception) {
            Logger.e(e) { "Cannot get portfolio items" }
            Result.failure(e)
        }

    suspend fun getServices(): Result<List<ServiceItem>> =
        try {
            val res = client.get(GetServices()).body<ApiResponse<List<ServiceItem>>>()
            Result.success(res.data)
        } catch (e: Exception) {
            Logger.e(e) { "Cannot get services" }
            Result.failure(e)
        }

    suspend fun getTechnologies(): Result<List<TechnologyItem>> =
        try {
            val res = client.get(GetTechnologies()).body<ApiResponse<List<TechnologyItem>>>()
            Result.success(res.data)
        } catch (e: Exception) {
            Logger.e(e) { "Cannot get technologies" }
            Result.failure(e)
        }
}
