package com.example.mvvm_news_app.di.component

import android.content.Context
import com.example.mvvm_news_app.NewsApplication
import com.example.mvvm_news_app.data.api.NetworkHelper
import com.example.mvvm_news_app.data.api.NetworkServices
import com.example.mvvm_news_app.data.local.DatabaseHelperImpl
import com.example.mvvm_news_app.data.repository.*
import com.example.mvvm_news_app.di.ApplicationContext
import com.example.mvvm_news_app.di.module.ApplicationModule
import com.example.mvvm_news_app.utils.DefaultDispatcher
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkServices

    fun getDbHelper(): DatabaseHelperImpl

    fun getTopHeadlineRepository(): TopHeadlineRepository

    fun getNewsSourcesRepository(): NewsSourcesRepository

    fun getCountriesRepository(): CountriesRepository

    fun getLanguageRepository(): LanguageRepository

    fun getSearchNewRepository(): SearchRepository

    fun getNetworkHelper(): NetworkHelper

    fun getDefaultDispatcher(): DefaultDispatcher

}
