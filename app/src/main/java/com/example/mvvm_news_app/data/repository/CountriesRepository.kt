package com.example.mvvm_news_app.data.repository

import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.model.Country
import com.example.mvvm_news_app.utils.AppConstant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountriesRepository @Inject constructor(private val networkService: NetworkServices) {

    fun getCountries(): Flow<List<Country>> {
        return flow {
            emit(AppConstant.COUNTRIES)
        }
    }
}
