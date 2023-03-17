package com.example.mvvm_news_app.data.repository

import com.example.mvvm_news_app.data.model.Language
import com.example.mvvm_news_app.utils.AppConstant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LanguageRepository @Inject constructor() {

    fun getLanguages(): Flow<List<Language>> {
        return flow {
            emit(AppConstant.LANGUAGES)
        }
    }
}
