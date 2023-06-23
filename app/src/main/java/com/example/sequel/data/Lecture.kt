package com.example.sequel.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Lecture(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    @PrimaryKey
    val header: String,
    text: String,
    topic: String
) : BaseSqlData(text, topic)