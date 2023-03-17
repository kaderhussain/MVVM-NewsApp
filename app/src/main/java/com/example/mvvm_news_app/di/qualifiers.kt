package com.example.mvvm_news_app.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class DatabaseName

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApiKey

