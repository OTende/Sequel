package com.example.sequel.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sequel.data.Lecture
import com.example.sequel.data.Practice

@Database(
    entities = [Lecture::class, Practice::class],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getDao(): MainDAO
}