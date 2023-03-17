package com.example.mvvm_news_app.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mvvm_news_app.data.model.ApiArticle
import com.example.mvvm_news_app.data.repository.SearchRepository
import com.example.mvvm_news_app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    fun fetchSearchNews(query: String) = searchRepository.getSearchNewsPage(query).cachedIn(viewModelScope)

}
