package com.example.sequel.network

import com.example.sequel.data.Lecture
import com.example.sequel.data.Practice
import retrofit2.http.GET


interface DataService {
    @GET
    suspend fun getLectures(): List<Lecture>

    @GET
    suspend fun getPractices(): List<Practice>
}