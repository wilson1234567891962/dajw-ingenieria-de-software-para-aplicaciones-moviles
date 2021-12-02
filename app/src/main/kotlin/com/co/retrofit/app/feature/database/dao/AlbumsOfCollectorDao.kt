package com.co.retrofit.app.feature.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.co.retrofit.app.feature.model.dto.Album

@Dao
interface AlbumsOfCollectorDao {
    @Query("SELECT * FROM albums_table WHERE collectorId = :collectorId")
    fun getAlbumsOfCollector(collectorId:Int):List<Album>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(album: Album)

    @Query("DELETE FROM albums_table")
    suspend fun clear():Void

    @Query("DELETE FROM albums_table WHERE collectorId = :collectorId")
    suspend fun deleteAll(collectorId: Int):Int
}