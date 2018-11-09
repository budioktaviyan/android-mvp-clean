package id.kotlin.android.features.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import id.kotlin.android.R
import id.kotlin.android.core.ext.CoreConfig
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeView {

    @Inject lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val params = HomeParam(CoreConfig.API_KEY)
        presenter.discoverMovie(params)
    }

    override fun onShowDiscoverMovie(entity: HomeEntity) {}
}