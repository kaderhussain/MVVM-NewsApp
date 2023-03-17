package com.example.mvvm_news_app.data.repository

import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.model.NewsSources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsSourcesRepository @Inject constructor(private val networkService: NetworkServices) {

    fun getNewsSources(): Flow<List<NewsSources>> {
        return flow {
            emit(networkService.getNewsSources())
        }.map {
            it.sources
        }

    }

}
