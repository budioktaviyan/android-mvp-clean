package id.kotlin.android.features.detail

import id.kotlin.android.features.home.Movie

class DetailPresenter {

    private lateinit var view: DetailView

    fun onAttach(view: DetailView) {
        this.view = view
    }

    fun showMovie(movie: Movie) {
        view.onShowMovie(movie)
    }
}