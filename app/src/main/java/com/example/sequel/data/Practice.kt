package com.example.sequel.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Practice(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    text: String,
    topic: String,
//    val answers: List<String>,
    @ColumnInfo(name = "is_complete") var isComplete: Boolean = false
) : BaseSqlData(text, topic) {
}