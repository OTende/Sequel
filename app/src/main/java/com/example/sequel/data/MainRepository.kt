package com.example.sequel.data

import com.example.sequel.data.db.MainDAO
import com.example.sequel.network.DataService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dao: MainDAO,
    val retrofit: DataService
) {
    suspend fun getLecturesFromGithub() = retrofit.getLectures()
    suspend fun getLectures() = dao.getLectures()
    suspend fun getPractices() = dao.getPractices()
    suspend fun savePractices(practices: List<Practice>) = dao.insertPractices(practices)
    suspend fun saveLectures(lectures: List<Lecture>) = dao.insertLectures(lectures)
    suspend fun completePractice(id: Int?) = dao.completePracticeById(id)
}