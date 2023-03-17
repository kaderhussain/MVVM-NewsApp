package com.example.mvvm_news_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_news_app.data.local.entity.ArticleRemoteKeys

@Dao
interface RemoteKeysDao {


    @Query("SELECT * FROM ArticleRemoteKeys where id=:id")
    suspend fun getRemoteKeys(id: String): ArticleRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<ArticleRemoteKeys>)

    @Query("Delete from ArticleRemoteKeys")
    suspend fun deleteAll(): Int


}
