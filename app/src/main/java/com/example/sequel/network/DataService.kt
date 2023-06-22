package com.example.sequel.network

import android.widget.Toast
import com.example.sequel.data.Lecture
import com.example.sequel.data.Practice
import retrofit2.http.GET

const val BASE_URL = "https://raw.githubusercontent.com/OTende/SQLTrainer/master/text/"

interface DataService {
    @GET("lectures.txt")
    suspend fun getLectures(): List<Lecture>

    @GET("practices.txt")
    suspend fun getPractices(): List<Practice>
}