package ru.fl35hdr0ppp.profile.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.fl35hdr0ppp.profile.R
import ru.fl35hdr0ppp.profile.common.loadImage
import ru.fl35hdr0ppp.profile.data.model.Post

class ProfileAdapter : ListAdapter<Post, RecyclerView.ViewHolder>(PostDiffUtil()) {

    companion object {
        const val VIEW_TYPE_USER_COMMUNICATION = 0
        const val VIEW_TYPE_POST = 1
    }

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val postText: TextView = view.findViewById(R.id.postText)
        private val postImage: ImageView = view.findViewById(R.id.postImage)
        private val likeButton: Button = view.findViewById(R.id.likeButton)
        private val commentButton: Button = view.findViewById(R.id.commentButton)

        // :)))
        @SuppressLint("SetTextI18n")
        fun bind(post: Post) {
            postText.text = post.text

            post.imageUrl?.let {
                postImage.visibility = View.VISIBLE
                postImage.loadImage(it)
            }

            likeButton.text = "❤ ${post.likesCount}"
            commentButton.text = "\uD83D\uDCAC ${post.commentsCount}"

            likeButton.setOnClickListener {
                Toast.makeText(it.context, "Лайкнуто!", Toast.LENGTH_SHORT).show()
            }

            commentButton.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "Пока не возможности комментировать :(",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    inner class UserCommunicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val addFriendButton: Button = view.findViewById(R.id.addFriendButton)
        private val messageButton: ImageView = view.findViewById(R.id.messageButton)
        private val callButton: ImageView = view.findViewById(R.id.callButton)

        fun bind() {
            addFriendButton.setOnClickListener {
                Toast.makeText(it.context, "Добавлен в друзья!", Toast.LENGTH_SHORT).show()
            }

            messageButton.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "Пока не возможности писать пользователям :(",
                    Toast.LENGTH_SHORT
                ).show()
            }

            callButton.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "Пока не возможности звонить пользователям :(",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_USER_COMMUNICATION -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_communication_layout, parent, false)
                UserCommunicationViewHolder(view)
            }

            VIEW_TYPE_POST -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
                PostViewHolder(view)
            }

            else -> throw IllegalArgumentException("invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> holder.bind(getItem(position))
            is UserCommunicationViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_USER_COMMUNICATION
        } else {
            VIEW_TYPE_POST
        }
    }

}
