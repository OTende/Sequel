package com.example.sequel.data

import com.example.sequel.data.db.MainDAO
import com.example.sequel.network.DataService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dao: MainDAO,
    private val retrofit: DataService
) {
    init {
        CoroutineScope(Job()).launch {
            withContext(Dispatchers.Default) {
                try {
                    saveLectures(retrofit.getLectures())
                    savePractices(retrofit.getPractices())
                } catch (_: Exception) {}
            }
        }
    }

    suspend fun getLectures() = dao.getLectures()
    suspend fun getPractices() = dao.getPractices()
    private suspend fun savePractices(practices: List<Practice>) = dao.insertPractices(practices)
    private suspend fun saveLectures(lectures: List<Lecture>) = dao.insertLectures(lectures)
    suspend fun completePractice(id: Int) = dao.completePracticeById(id)
    suspend fun getPractice(id: Int): Practice = dao.getPracticeById(id)
}