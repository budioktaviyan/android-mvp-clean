package id.kotlin.android.features.home

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()
    fun onShowDiscoverMovie(entity: HomeEntity)
    fun onShowErrorMessage(message: String)
}