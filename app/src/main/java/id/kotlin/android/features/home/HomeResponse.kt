package id.kotlin.android.features.home

import com.google.gson.annotations.SerializedName

sealed class HomeResponse {

    data class Data(
            @SerializedName("page") val page: Long?,
            @SerializedName("total_pages") val totalPages: Long?,
            @SerializedName("results") val results: List<Result?>
    )

    data class Result(
            @SerializedName("title") val title: String?,
            @SerializedName("overview") val overview: String?,
            @SerializedName("poster_path") val posterPath: String?,
            @SerializedName("backdrop_path") val backdropPath: String?
    )
}