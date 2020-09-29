package com.upraxis.exam.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.upraxis.exam.model.database.daos.PersonDAO
import com.upraxis.exam.model.models.Person
import com.upraxis.exam.utils.ROOM_DB_UPRAXIS

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class UpraxisDB : RoomDatabase() {

    abstract fun getPersonDao(): PersonDAO

    companion object {
        private var INSTANCE: UpraxisDB? = null

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                UpraxisDB::class.java,
                ROOM_DB_UPRAXIS
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
