package id.kotlin.android.features.home

import id.kotlin.android.core.domain.DefaultObserver

class HomePresenter(private val usecase: HomeUsecase) {

    private lateinit var view: HomeView

    fun onAttach(view: HomeView) {
        this.view = view
    }

    fun onDetach() {
        usecase.dispose()
    }

    fun discoverMovie(params: HomeParam) {
        view.onShowLoading()
        usecase.execute(HomeUsecaseObserver(view), params)
    }
}

class HomeUsecaseObserver(private val view: HomeView) : DefaultObserver<HomeEntity>() {

    override fun onSuccess(entity: HomeEntity) {
        view.onHideLoading()
        view.onShowDiscoverMovie(entity)
    }

    override fun onError(exception: Throwable) {
        view.onHideLoading()
        view.onShowErrorMessage(exception.localizedMessage)
    }
}