package com.example.mvvm_news_app.data.api

import com.example.mvvm_news_app.di.ApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(@ApiKey private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("X-Api-Key", apiKey)
        return chain.proceed(request.build())
    }
}
