package com.kader.newsappkdr.di.component

import android.app.Activity
import android.content.Context
import com.kader.newsappkdr.di.ActivityContext
import com.kader.newsappkdr.di.ActivityScope
import com.kader.newsappkdr.di.module.ActivityModule
import com.kader.newsappkdr.ui.topheadline.TopHeadlineActivity
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
