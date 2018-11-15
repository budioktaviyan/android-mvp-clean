package id.kotlin.android.features.home

import id.kotlin.android.BuildConfig.IMAGE_URL
import io.reactivex.Single

class HomeRepository(private val factory: HomeFactory) {

    fun discoverMovie(params: HomeParam): Single<HomeEntity> =
            factory.discoverMovie(params).map {
                val page: Long = it.page ?: 0
                val totalPages: Long = it.totalPages ?: 0
                val movies: List<Movie> = it.results.map { result ->
                    val title = result?.title ?: ""
                    val overview = result?.overview ?: ""
                    val posterPath = "$IMAGE_URL/t/p/original/${result?.posterPath ?: ""}"
                    val backdropPath = "$IMAGE_URL/t/p/original${result?.backdropPath ?: ""}"
                    Movie(
                            title = title,
                            overview = overview,
                            posterPath = posterPath,
                            backdropPath = backdropPath
                    )
                }
                HomeEntity(page = page, totalPages = totalPages, movies = movies)
            }
}