package com.example.mvvm_news_app.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.model.ApiArticle
import com.example.mvvm_news_app.utils.AppConstant.LAST_PAGE

class SearchPagingSource (private val networkServices: NetworkServices,private val query:String) : PagingSource<Int, ApiArticle>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiArticle> {
        return try {
            val position = params.key ?: 1
            Log.d("SearchPagingSource", "position: $position")
            val response = networkServices.getSearchNews(query, position)
             LoadResult.Page(
                data = response.apiArticles,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == LAST_PAGE) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ApiArticle>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}
