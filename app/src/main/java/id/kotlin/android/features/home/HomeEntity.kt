package id.kotlin.android.features.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeEntity(
        val page: Long,
        val totalPages: Long,
        val movies: List<Movie>
) : Parcelable

@Parcelize
data class Movie(
        val title: String,
        val overview: String,
        val posterPath: String,
        val backdropPath: String
) : Parcelable