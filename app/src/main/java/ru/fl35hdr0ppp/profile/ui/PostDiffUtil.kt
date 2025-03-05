package ru.fl35hdr0ppp.profile.ui

import androidx.recyclerview.widget.DiffUtil
import ru.fl35hdr0ppp.profile.data.model.Post

class PostDiffUtil : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}