package com.example.mvvm_news_app.ui.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_news_app.data.model.Country
import com.example.mvvm_news_app.data.repository.CountriesRepository
import com.example.mvvm_news_app.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CountryViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {
    private val _countryList = MutableStateFlow<Resource<List<Country>>>(Resource.Loading())

    var countryList: StateFlow<Resource<List<Country>>> = _countryList

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            countriesRepository.getCountries()
                .catch { e ->
                    _countryList.value = Resource.Error(e.toString())
                }
                .collect {
                    _countryList.value = Resource.Success(it)
                }
        }
    }
}
