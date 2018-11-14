package id.kotlin.android.core.ext

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

internal inline fun <reified T : Any> clazz() = T::class.java

internal fun ImageView.load(url: String) {
    Glide.with(this.context).load(url).into(this)
}

internal fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(this.context).inflate(layoutRes, this, false)

internal fun View.show() {
    visibility = VISIBLE
}

internal fun View.hide() {
    visibility = GONE
}