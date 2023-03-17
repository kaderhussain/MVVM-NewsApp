package com.example.mvvm_news_app.ui.languages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_news_app.data.model.Language
import com.example.mvvm_news_app.data.repository.LanguageRepository
import com.example.mvvm_news_app.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LanguageViewModel(private val languageRepository: LanguageRepository) : ViewModel() {
    private val _languageList = MutableStateFlow<Resource<List<Language>>>(Resource.Loading())

    val languageList: StateFlow<Resource<List<Language>>> = _languageList

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            languageRepository.getLanguages()
                .catch { e ->
                    _languageList.value = Resource.Error(e.toString())
                }
                .collect {
                    _languageList.value = Resource.Success(it)
                }
        }
    }
}
