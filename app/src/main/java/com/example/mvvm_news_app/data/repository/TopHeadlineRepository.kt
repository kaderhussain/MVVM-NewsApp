package com.example.mvvm_news_app.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.local.AppDatabase
import com.example.mvvm_news_app.data.local.DatabaseHelperImpl
import com.example.mvvm_news_app.data.local.entity.Article
import com.example.mvvm_news_app.data.model.toArticle
import com.example.mvvm_news_app.data.paging.TopHeadlineRemoteMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Singleton
class TopHeadlineRepository @Inject constructor(
    private val networkService: NetworkServices,
    private val databaseHelperImpl: DatabaseHelperImpl,
    private val appDatabase: AppDatabase
) {

    fun getTopHeadlines(country: String, pageNumber: Int): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country, pageNumber))
        }
            .map {
                val apiArticles = it.apiArticles
                val articles = mutableListOf<Article>()
                for (apiArticle in apiArticles) {
                    articles.add(apiArticle.toArticle())
                }
                return@map articles
            }
            .flatMapConcat { articles ->
                return@flatMapConcat flow {
                    emit(databaseHelperImpl.deleteAll())
                }.flatMapConcat {
                    return@flatMapConcat databaseHelperImpl.insertAll(articles)
                }.flatMapConcat {
                    return@flatMapConcat databaseHelperImpl.getTopHeadline()
                }
            }

    }

    fun getTopHeadlinesPage(country: String) =
        Pager(
            config = PagingConfig(pageSize = 5, maxSize = 100),
            remoteMediator = TopHeadlineRemoteMediator(networkService, appDatabase, country),
            pagingSourceFactory = { databaseHelperImpl.getAllTopHeadlinePage() }
        ).flow

    fun getTopHeadlineDirectlyFromDB(): Flow<List<Article>> {
        return databaseHelperImpl.getTopHeadline()
    }

}
