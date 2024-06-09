package com.tinaciousdesign.portfoliokmm

import com.tinaciousdesign.portfoliokmm.networking.ApiClient
import com.tinaciousdesign.portfoliokmm.networking.responses.PortfolioItem
import com.tinaciousdesign.portfoliokmm.networking.responses.ServiceItem
import com.tinaciousdesign.portfoliokmm.networking.responses.TechnologyItem
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiUtils : KoinComponent {
    private val apiClient by inject<ApiClient>()

    suspend fun getTechnologies(): List<TechnologyItem> {
        return apiClient.getTechnologies().getOrElse { emptyList() }
    }

    suspend fun getServices(): List<ServiceItem> {
        return apiClient.getServices().getOrElse { emptyList() }
    }

    suspend fun getPortfolioItems(): List<PortfolioItem> {
        return apiClient.getPortfolioItems().getOrElse { emptyList() }
    }
}