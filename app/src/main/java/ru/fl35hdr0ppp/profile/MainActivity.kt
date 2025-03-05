package ru.fl35hdr0ppp.profile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fl35hdr0ppp.profile.common.loadImage
import ru.fl35hdr0ppp.profile.ui.ProfileAdapter
import ru.fl35hdr0ppp.profile.ui.ProfileViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ProfileViewModel
    private lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        adapter = ProfileAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.user.observe(this) { user ->
            findViewById<TextView>(R.id.user_name).text = user.name
            findViewById<TextView>(R.id.friends_number).text = "${user.friendsCount}"
            findViewById<TextView>(R.id.post_number).text = "${user.postsCount}"
            findViewById<TextView>(R.id.followers_number).text = "${user.followersCount}"
            findViewById<ImageView>(R.id.avatar).loadImage(user.avatarUrl)
        }

        viewModel.posts.observe(this) { posts ->
            adapter.submitList(posts)
        }

    }
}