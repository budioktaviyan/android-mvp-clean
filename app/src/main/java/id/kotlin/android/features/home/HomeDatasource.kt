package id.kotlin.android.features.home

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDatasource {

    @GET("/3/discover/movie")
    fun discoverMovie(
            @Query("api_key") apiKey: String,
            @Query("sort_by") sortBy: String
    ): Single<HomeResponse.Data>
}