package com.example.mvvm_news_app.data.model

import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val apiArticles: MutableList<ApiArticle> = ArrayList(),
)
