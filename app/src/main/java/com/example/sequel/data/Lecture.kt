package com.example.sequel.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Lecture(
    @PrimaryKey
    var id: Int? = null,
    text: String,
    topic: String,
    val header: String
) : BaseSqlData(text, topic)