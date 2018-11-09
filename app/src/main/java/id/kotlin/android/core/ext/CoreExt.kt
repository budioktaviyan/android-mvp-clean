package id.kotlin.android.core.ext

internal inline fun <reified T : Any> clazz() = T::class.java