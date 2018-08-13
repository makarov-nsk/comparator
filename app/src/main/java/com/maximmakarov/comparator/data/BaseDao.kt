package com.maximmakarov.comparator.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface BaseDao<T> {
    @Insert
    fun insert(vararg obj: T): List<Long>

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}