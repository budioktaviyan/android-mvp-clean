package id.kotlin.android.features.detail

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.android.core.di.PerFeature

@Module
class DetailModule {

    @PerFeature
    @Provides
    fun providesDetailPresenter(view: DetailView): DetailPresenter =
            DetailPresenter(view)
}

@Module
abstract class DetailSubmodule {

    @Binds
    @Suppress("unused")
    abstract fun bindsDetailView(activity: DetailActivity): DetailView
}