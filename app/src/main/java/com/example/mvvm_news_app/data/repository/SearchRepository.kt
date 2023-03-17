package com.example.mvvm_news_app.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.model.ApiArticle
import com.example.mvvm_news_app.data.paging.SearchPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val networkService: NetworkServices) {

    fun getSearchNews(query: String): Flow<List<ApiArticle>> {
        return flow {
            emit(networkService.getSearchNews(query))
        }.map {
            it.apiArticles
        }
    }

    fun getSearchNewsPage(query: String) =
        Pager(
            config = PagingConfig(pageSize = 5, maxSize = 100),
            pagingSourceFactory = { SearchPagingSource(networkService, query) }
        ).flow


}
