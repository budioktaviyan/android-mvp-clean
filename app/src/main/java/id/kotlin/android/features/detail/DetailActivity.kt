package id.kotlin.android.features.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import dagger.android.AndroidInjection
import id.kotlin.android.R
import id.kotlin.android.features.home.Movie
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailView {

    @Inject lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        AndroidInjection.inject(this)

        val movie = intent.getParcelableExtra<Movie>("MOVIE")
        presenter.onAttach(this)
        presenter.showMovie(movie)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onShowMovie(movie: Movie) {
        title = movie.title
        rv_detail.adapter = DetailAdapter(movie)
    }
}