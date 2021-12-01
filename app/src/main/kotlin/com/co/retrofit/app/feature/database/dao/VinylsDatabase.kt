package com.co.retrofit.app.feature.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.co.retrofit.app.feature.model.dto.Album
import com.co.retrofit.app.feature.model.dto.Artist
import com.co.retrofit.app.feature.model.dto.Collector



@Database(entities = [Collector::class, Artist::class, Album::class], version = 2, exportSchema = false)
abstract class VinylRoomDatabase : RoomDatabase() {

    abstract fun artistsDao(): ArtistsDao
    abstract fun collectorsDao(): CollectorsDao
    abstract fun albumsDao(): AlbumsOfArtistDao
    abstract fun albumsOfCollectorDao(): AlbumsOfCollectorDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: VinylRoomDatabase? = null

        fun getDatabase(context: Context): VinylRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VinylRoomDatabase::class.java,
                    "vinyls_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}