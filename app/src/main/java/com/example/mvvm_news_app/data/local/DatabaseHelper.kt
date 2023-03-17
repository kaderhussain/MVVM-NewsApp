package com.example.mvvm_news_app.data.local

import androidx.paging.PagingSource
import com.example.mvvm_news_app.data.local.entity.Article
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    fun getTopHeadline(): Flow<List<Article>>

    fun getAllTopHeadlinePage(): PagingSource<Int, Article>

    fun deleteAll(): Int

    fun insertAll(article: List<Article>): Flow<Unit>

}
