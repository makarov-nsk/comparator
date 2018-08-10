package com.maximmakarov.comparator.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.maximmakarov.comparator.data.attribute.*
import com.maximmakarov.comparator.data.item.*
import com.maximmakarov.comparator.data.template.*


@Database(entities = [Template::class, Item::class, ItemAttributeDetail::class, Attribute::class, AttributeGroup::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun templateDao(): TemplateDao
    abstract fun itemDao(): ItemDao
    abstract fun itemDataDao(): ItemAttributeDetailDao
    abstract fun attributeDao(): AttributeDao
    abstract fun attributeGroupDao(): AttributeGroupDao

    companion object {
        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<PrePopulateDatabaseWorker>().build()
                            WorkManager.getInstance().enqueue(request)
                        }
                    }).build()
        }
    }
}