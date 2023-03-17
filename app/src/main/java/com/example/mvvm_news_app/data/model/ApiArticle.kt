package com.example.mvvm_news_app.data.model

import com.google.gson.annotations.SerializedName
import com.example.mvvm_news_app.data.local.entity.Article

data class ApiArticle(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val imageUrl: String = "",
    @SerializedName("source")
    val apiSource: ApiSource
)

fun ApiArticle.toArticle(): Article = Article(
    title = this.title,
    description = this.description,
    url = this.url,
    imageUrl = this.imageUrl,
    sourceId = this.apiSource.id,
    sourceName = this.apiSource.name
)
