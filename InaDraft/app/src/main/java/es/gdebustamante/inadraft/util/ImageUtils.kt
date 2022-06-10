package es.gdebustamante.inadraft.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Clase de utilidad para, dado una url, pintarla en el ImageView pasado como extensión
 */
fun ImageView.loadGlideCenterImage(url: String) {
    Glide.with(context)
        .load(url)
        .centerInside()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}