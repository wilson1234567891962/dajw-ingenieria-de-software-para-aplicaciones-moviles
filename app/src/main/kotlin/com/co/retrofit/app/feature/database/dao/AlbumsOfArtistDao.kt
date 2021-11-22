package com.co.retrofit.app.feature.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.co.retrofit.app.feature.model.dto.Album

@Dao
interface AlbumsOfArtistDao {
    @Query("SELECT * FROM albums_table WHERE artistId = :artistId")
    fun getAlbumsOfArtist(artistId:Int):List<Album>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(album: Album)

    @Query("DELETE FROM albums_table")
    suspend fun clear():Void

    @Query("DELETE FROM albums_table WHERE artistId = :artistId")
    suspend fun deleteAll(artistId: Int):Int
}