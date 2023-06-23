package com.example.sequel.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.sequel.data.db.TypeConverter

@Entity
@TypeConverters(TypeConverter::class)
class Practice(
    @PrimaryKey val id: Int,
    text: String,
    topic: String,
    @TypeConverters(TypeConverter::class)
    val answers: List<String>,
    @ColumnInfo(name = "is_complete") var isComplete: Boolean = false
) : BaseSqlData(text, topic)