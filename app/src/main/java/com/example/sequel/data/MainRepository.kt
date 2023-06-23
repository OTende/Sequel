package com.example.sequel.data

import com.example.sequel.data.db.MainDAO
import com.example.sequel.network.DataService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dao: MainDAO,
    private val retrofit: DataService
) {
    init {
        CoroutineScope(Job()).launch {
            withContext(Dispatchers.Default) {
                saveLectures(retrofit.getLectures())
                savePractices(retrofit.getPractices())
            }
        }
    }

    suspend fun getLectures() = dao.getLectures()
    suspend fun getPractices() = dao.getPractices()
    suspend fun savePractices(practices: List<Practice>) = dao.insertPractices(practices)
    suspend fun saveLectures(lectures: List<Lecture>) = dao.insertLectures(lectures)
    suspend fun completePractice(id: Int) = dao.completePracticeById(id)
    suspend fun getPractice(id: Int): Practice = coroutineScope {
        val practice = async {
            dao.getPracticeById(id)
        }
        practice.await()
    }
}