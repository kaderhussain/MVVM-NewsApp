package com.example.mvvm_news_app.ui.news_sources

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_news_app.data.model.NewsSources
import com.example.mvvm_news_app.data.repository.NewsSourcesRepository
import com.example.mvvm_news_app.utils.DispatcherProvider
import com.example.mvvm_news_app.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NewsSourcesViewModel(
    private val newsSourcesRepository: NewsSourcesRepository,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _newSourceList = MutableStateFlow<Resource<List<NewsSources>>>(Resource.Loading())

    val newSourceList: StateFlow<Resource<List<NewsSources>>> = _newSourceList

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch(dispatcherProvider.main) {
            newsSourcesRepository.getNewsSources()
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _newSourceList.value = Resource.Error(e.toString())
                }
                .collect {
                    _newSourceList.value = Resource.Success(it)
                }
        }
    }
}
