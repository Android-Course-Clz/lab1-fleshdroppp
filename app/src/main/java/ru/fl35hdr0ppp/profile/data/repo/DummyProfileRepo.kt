package ru.fl35hdr0ppp.profile.data.repo

import ru.fl35hdr0ppp.profile.data.model.Post
import ru.fl35hdr0ppp.profile.data.model.User

class DummyProfileRepo {

    fun getUser(): User = User(
        avatarUrl = "https://i.pinimg.com/736x/3f/d6/88/3fd6884130e05a9648639967b0c315ba.jpg",
        username = "fl3hdr0ppp",
        name = "Хуснутдинов Аким",
        friendsCount = 100,
        followersCount = 200,
        postsCount = 50
    )

    fun getPosts(): List<Post> = listOf(
        Post(
            id = 1,
            text = "Первый пост!",
            likesCount = 10,
            commentsCount = 5,
            imageUrl = "https://i.pinimg.com/736x/63/3b/33/633b33407e0a948007ce2e6f81354a40.jpg"
        ),
        Post(
            id = 2,
            text = "Второй пост!",
            likesCount = 7,
            commentsCount = 2
        ),
        Post(
            id = 3,
            text = "В деревне так хорошо",
            likesCount = 7,
            commentsCount = 2,
            imageUrl = "https://i.pinimg.com/736x/0d/f7/ba/0df7ba5af478a06349778b8796b77691.jpg"
        ),
        Post(
            id = 4,
            text = "SAMPLE POST :LASJDKFHNSKDLJFN",
            likesCount = 7,
            commentsCount = 2
        ),
        Post(
            id = 5,
            text = "Первый пост!",
            likesCount = 10,
            commentsCount = 5,
            imageUrl = "https://i.pinimg.com/736x/63/3b/33/633b33407e0a948007ce2e6f81354a40.jpg"
        ),
        Post(
            id = 6,
            text = "Второй пост!",
            likesCount = 7,
            commentsCount = 2
        ),
        Post(
            id = 7,
            text = "В деревне так хорошо",
            likesCount = 7,
            commentsCount = 2,
            imageUrl = "https://i.pinimg.com/736x/0d/f7/ba/0df7ba5af478a06349778b8796b77691.jpg"
        ),
        Post(
            id = 8,
            text = "SAMPLE POST :LASJDKFHNSKDLJFN",
            likesCount = 7,
            commentsCount = 2
        )
    ).reversed()

}