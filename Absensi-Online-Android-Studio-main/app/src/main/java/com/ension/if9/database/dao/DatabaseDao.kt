package com.ension.if9.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.ension.if9.model.ModelDatabase
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM tbl_absensi")
    fun getAllHistory(): LiveData<List<ModelDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_absensi WHERE uid= :uid")
    fun deleteHistoryById(uid: Int)

    @Query("DELETE FROM tbl_absensi")
    fun deleteAllHistory()
}