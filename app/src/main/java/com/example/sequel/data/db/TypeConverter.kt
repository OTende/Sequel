package com.example.sequel.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.stream.Collectors


class TypeConverter {
    @TypeConverter
    fun fromList(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromString(string: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, listType)
    }
}