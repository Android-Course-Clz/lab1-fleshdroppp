package ru.fl35hdr0ppp.profile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.fl35hdr0ppp.profile.data.model.Post
import ru.fl35hdr0ppp.profile.data.model.User
import ru.fl35hdr0ppp.profile.data.repo.DummyProfileRepo

class ProfileViewModel: ViewModel() {
    private val repository = DummyProfileRepo()

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadProfile()
    }

    private fun loadProfile() {
        _user.value = repository.getUser()
        _posts.value = repository.getPosts()
    }
}