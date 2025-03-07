package ru.fl35hdr0ppp.profile.common

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) =
    Glide.with(this.context)
        .load(url)
        .into(this)