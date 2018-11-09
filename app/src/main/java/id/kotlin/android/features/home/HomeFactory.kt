package id.kotlin.android.features.home

import io.reactivex.Single

class HomeFactory(private val datasource: HomeDatasource) {

    fun discoverMovie(params: HomeParam): Single<HomeResponse.Data> =
            datasource.discoverMovie(params.apiKey, params.sortBy)
}