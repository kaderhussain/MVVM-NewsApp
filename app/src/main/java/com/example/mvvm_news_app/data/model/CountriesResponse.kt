package com.example.mvvm_news_app.data.model

import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("sources")
    val sources: List<Country> = ArrayList(),
)
