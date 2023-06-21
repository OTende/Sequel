package com.example.sequel.data

class Lecture(
    text: String,
    topic: String,
    val header: String
) : BaseSqlData(text, topic)