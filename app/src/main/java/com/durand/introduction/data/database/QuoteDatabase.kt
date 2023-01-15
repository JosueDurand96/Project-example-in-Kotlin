package com.durand.introduction.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.durand.introduction.data.database.dao.QuoteDao
import com.durand.introduction.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}