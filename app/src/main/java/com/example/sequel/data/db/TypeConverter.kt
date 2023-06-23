package com.example.sequel.data.db

import androidx.room.TypeConverter
import com.example.sequel.data.Practice
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.stream.Collectors

class TypeConverter {
    @TypeConverter
    fun fromList(list: List<String>): String {
//        val type =
        return list.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun fromString(string: String): List<String> {
//        return string.split(",")
//        val listType = object : TypeToken<List<String>>() {}.type
//        Gson().fromJson(string, listType)
        return string.split(",")
    }
}