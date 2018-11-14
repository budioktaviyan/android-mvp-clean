package id.kotlin.android.features.home

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import id.kotlin.android.R
import id.kotlin.android.core.ext.inflate
import id.kotlin.android.core.ext.load
import id.kotlin.android.features.home.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.item_home.view.*

interface HomeListener {

    fun onClick(movie: Movie)
}

class HomeAdapter(
        private val listener: HomeListener,
        private val movies: List<Movie>
) : Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
            HomeViewHolder(parent.inflate(R.layout.item_home))

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindView(movies[holder.adapterPosition])
    }

    override fun getItemCount(): Int = movies.size

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        fun bindView(movie: Movie) {
            itemView.iv_home.load(movie.posterPath)
            itemView.tv_home.text = movie.title
            itemView.rootView.setOnClickListener { listener.onClick(movie) }
        }
    }
}