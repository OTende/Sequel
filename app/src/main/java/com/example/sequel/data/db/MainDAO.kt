package com.example.sequel.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sequel.data.Lecture
import com.example.sequel.data.Practice

@Dao
interface MainDAO {
    @Insert
    suspend fun insertLectures(lectures: List<Lecture>)

    @Insert
    suspend fun insertPractices(practices: List<Practice>)

    @Query("SELECT * FROM Lecture")
    suspend fun getLectures(): List<Lecture>

    @Query("SELECT * FROM Practice")
    suspend fun getPractices(): List<Practice>

    @Query("UPDATE Practice SET is_complete = 1 WHERE id = :id")
    suspend fun completePracticeById(id: Int?)
}