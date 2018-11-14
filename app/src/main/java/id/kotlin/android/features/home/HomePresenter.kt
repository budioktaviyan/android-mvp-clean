package id.kotlin.android.features.home

import id.kotlin.android.core.domain.DefaultObserver

class HomePresenter(private val view: HomeView, private val usecase: HomeUsecase) {

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
}