package com.tinaciousdesign.portfoliokmm

import com.tinaciousdesign.portfoliokmm.networking.ApiClient
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import com.tinaciousdesign.portfoliokmm.networking.responses.ServiceItem
import com.tinaciousdesign.portfoliokmm.networking.responses.TechnologyItem
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiUtils : KoinComponent {
    private val apiClient by inject<ApiClient>()

    private var cachedPortfolioItems = listOf<PortfolioItem>()
    private var cachedTechnologyItems = listOf<TechnologyItem>()
    private var cachedServices = listOf<ServiceItem>()

    suspend fun getTechnologies(): List<TechnologyItem> {
        if (cachedTechnologyItems.isNotEmpty()) {
            return cachedTechnologyItems
        }

        val results = apiClient.getTechnologies().getOrElse { emptyList() }
        cachedTechnologyItems = results

        return cachedTechnologyItems
    }

    suspend fun getServices(): List<ServiceItem> {
        if (cachedServices.isNotEmpty()) {
            return cachedServices
        }

        val results = apiClient.getServices().getOrElse { emptyList() }
        cachedServices = results

        return cachedServices
    }

    suspend fun getPortfolioItems(): List<PortfolioItem> {
        if (cachedPortfolioItems.isNotEmpty()) {
            return cachedPortfolioItems
        }

        val results = apiClient.getPortfolioItems().getOrElse { emptyList() }
        cachedPortfolioItems = results

        return cachedPortfolioItems
    }
}
