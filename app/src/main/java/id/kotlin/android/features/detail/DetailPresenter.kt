package id.kotlin.android.features.detail

import id.kotlin.android.features.home.Movie

class DetailPresenter(private val view: DetailView) {

    fun showMovie(movie: Movie) {
        view.onShowMovie(movie)
    }
}