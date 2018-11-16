package id.kotlin.android.features.detail

import android.content.res.Resources.NotFoundException
import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.android.R
import id.kotlin.android.core.ext.inflate
import id.kotlin.android.core.ext.load
import id.kotlin.android.features.home.Movie
import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.item_detail_header.view.*

enum class ViewType {
    HEADER,
    BODY
}

class DetailAdapter(private val movie: Movie) : Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            when (viewType) {
                ViewType.HEADER.ordinal -> DetailHeaderViewHolder(parent.inflate(R.layout.item_detail_header))
                ViewType.BODY.ordinal -> DetailViewHolder(parent.inflate(R.layout.item_detail))
                else -> throw NotFoundException("View not found!")
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is DetailHeaderViewHolder -> holder.bindView(movie)
            is DetailViewHolder -> holder.bindView(movie)
        }
    }

    override fun getItemCount(): Int = ViewType.values().size

    override fun getItemViewType(position: Int): Int =
            when (position) {
                0 -> ViewType.HEADER.ordinal
                1 -> ViewType.BODY.ordinal
                else -> throw NotFoundException("View type not found!")
            }

    inner class DetailHeaderViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(movie: Movie) {
            with(itemView) {
                iv_detail.load(movie.backdropPath)
            }
        }
    }

    inner class DetailViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(movie: Movie) {
            with(itemView) {
                tv_detail.text = movie.overview
            }
        }
    }
}