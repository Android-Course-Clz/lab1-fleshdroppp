package ru.fl35hdr0ppp.profile.data.model

data class User(
    val avatarUrl: String,
    val username: String,
    val name: String,
    val friendsCount: Int,
    val followersCount: Int,
    val postsCount: Int
)
