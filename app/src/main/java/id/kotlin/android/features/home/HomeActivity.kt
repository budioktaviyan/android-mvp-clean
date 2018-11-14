package id.kotlin.android.features.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import id.kotlin.android.R
import id.kotlin.android.core.ext.CoreConfig
import id.kotlin.android.core.ext.clazz
import id.kotlin.android.core.ext.hide
import id.kotlin.android.core.ext.show
import id.kotlin.android.features.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView, HomeListener {

    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val params = HomeParam(CoreConfig.API_KEY)
        presenter.discoverMovie(params)
    }

    override fun onShowLoading() {
        pb_home.show()
    }

    override fun onHideLoading() {
        pb_home.hide()
    }

    override fun onShowDiscoverMovie(entity: HomeEntity) {
        rv_home.adapter = HomeAdapter(this, entity.movies)
    }

    override fun onClick(movie: Movie) {
        Intent(this, clazz<DetailActivity>()).apply {
            putExtra("MOVIE", movie)
        }.apply { startActivity(this) }
    }
}