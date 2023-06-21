package com.example.sequel.data

class Practice(
    text: String,
    topic: String,
    val answers: Array<String>
) : BaseSqlData(text, topic) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Practice

        if (text != other.text) return false
        if (topic != other.topic) return false
        if (!answers.contentEquals(other.answers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = text.hashCode()
        result = 31 * result + topic.hashCode()
        result = 31 * result + answers.contentHashCode()
        return result
    }
}