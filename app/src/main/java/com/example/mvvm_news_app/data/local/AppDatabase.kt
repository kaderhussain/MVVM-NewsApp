package com.example.mvvm_news_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_news_app.data.local.dao.ArticleDao
import com.example.mvvm_news_app.data.local.dao.RemoteKeysDao
import com.example.mvvm_news_app.data.local.entity.Article
import com.example.mvvm_news_app.data.local.entity.ArticleRemoteKeys

@Database(entities = [Article::class, ArticleRemoteKeys::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
    abstract fun remoteKeysDao(): RemoteKeysDao

}
