package com.example.mvvm_news_app.di.component

import android.app.Activity
import android.content.Context
import com.example.mvvm_news_app.di.ActivityContext
import com.example.mvvm_news_app.di.ActivityScope
import com.example.mvvm_news_app.di.module.ActivityModule
import com.example.mvvm_news_app.ui.countries.CountryActivity
import com.example.mvvm_news_app.ui.languages.LanguageActivity
import com.example.mvvm_news_app.ui.main.MainActivity
import com.example.mvvm_news_app.ui.news_sources.NewsSourcesActivity
import com.example.mvvm_news_app.ui.search.SearchActivity
import com.example.mvvm_news_app.ui.topheadline.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    @ActivityContext
    fun getContext(): Context

    fun injectTopHeadline(activity: TopHeadlineActivity)

    fun injectNewsSources(activity: NewsSourcesActivity)

    fun injectMain(activity: MainActivity)

    fun injectCountires(activity: CountryActivity)

    fun injectLanguage(activity: LanguageActivity)

    fun injectSearchNews(activity: SearchActivity)

    fun inject(activity: Activity)


}
