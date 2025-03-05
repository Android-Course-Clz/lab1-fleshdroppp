package ru.fl35hdr0ppp.profile.data.model

data class Post(
    val id: Int,
    val text: String,
    val likesCount: Int,
    val commentsCount: Int,
    val imageUrl: String? = null,
)
