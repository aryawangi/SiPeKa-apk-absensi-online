package com.ension.if9.database

import androidx.room.Database
import com.ension.if9.model.ModelDatabase
import androidx.room.RoomDatabase
import com.ension.if9.database.dao.DatabaseDao

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}