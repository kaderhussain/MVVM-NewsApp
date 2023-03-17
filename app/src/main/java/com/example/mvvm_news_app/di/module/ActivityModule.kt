package com.example.mvvm_news_app.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_news_app.data.api.NetworkHelper
import com.example.mvvm_news_app.data.repository.*
import com.example.mvvm_news_app.di.ActivityContext
import com.example.mvvm_news_app.ui.base.ViewModelProviderFactory
import com.example.mvvm_news_app.ui.countries.CountryAdapter
import com.example.mvvm_news_app.ui.countries.CountryViewModel
import com.example.mvvm_news_app.ui.languages.LanguageAdapter
import com.example.mvvm_news_app.ui.languages.LanguageViewModel
import com.example.mvvm_news_app.ui.news_sources.NewsSourcesAdapter
import com.example.mvvm_news_app.ui.news_sources.NewsSourcesViewModel
import com.example.mvvm_news_app.ui.search.SearchViewAdapter
import com.example.mvvm_news_app.ui.search.SearchViewModel
import com.example.mvvm_news_app.ui.topheadline.TopHeadlineAdapter
import com.example.mvvm_news_app.ui.topheadline.TopHeadlineViewModel
import com.example.mvvm_news_app.utils.DefaultDispatcher
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }


    @Provides
    fun provideNewsListViewModel(
        topHeadlineRepository: TopHeadlineRepository,
        networkHelper: NetworkHelper,
        defaultDispatcher: DefaultDispatcher
    ): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository, networkHelper, defaultDispatcher)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideNewsSourcesViewModel(
        newsSourcesRepository: NewsSourcesRepository,
        defaultDispatcher: DefaultDispatcher
    ): NewsSourcesViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(NewsSourcesViewModel::class) {
                NewsSourcesViewModel(newsSourcesRepository, defaultDispatcher)
            })[NewsSourcesViewModel::class.java]
    }

    @Provides
    fun provideSearchNewsViewModel(searchRepository: SearchRepository): SearchViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(SearchViewModel::class) {
                SearchViewModel(searchRepository)
            })[SearchViewModel::class.java]
    }

    @Provides
    fun provideCountriesViewModel(countriesRepository: CountriesRepository): CountryViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(CountryViewModel::class) {
                CountryViewModel(countriesRepository)
            })[CountryViewModel::class.java]
    }

    @Provides
    fun provideLanguageViewModel(languageRepository: LanguageRepository): LanguageViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(LanguageViewModel::class) {
                LanguageViewModel(languageRepository)
            })[LanguageViewModel::class.java]
    }


    @Provides
    fun provideDummiesAdapter() = TopHeadlineAdapter()

    @Provides
    fun provideNewsSourcesAdapter() = NewsSourcesAdapter(ArrayList())

    @Provides
    fun provideCountriesAdapter() = CountryAdapter(ArrayList())

    @Provides
    fun provideLanguageAdapter() = LanguageAdapter(ArrayList())

    @Provides
    fun provideSearchAdapter() = SearchViewAdapter()


}
