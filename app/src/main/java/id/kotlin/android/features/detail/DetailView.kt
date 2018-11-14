package id.kotlin.android.features.detail

import id.kotlin.android.features.home.Movie

interface DetailView {

    fun onShowMovie(movie: Movie)
}