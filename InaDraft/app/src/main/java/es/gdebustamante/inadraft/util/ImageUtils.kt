package es.gdebustamante.inadraft.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadGlideCenterImage(url: String) {
    Glide.with(context)
        .load(url)
        .centerInside()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}