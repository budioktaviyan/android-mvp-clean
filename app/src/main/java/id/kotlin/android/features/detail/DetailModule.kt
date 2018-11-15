package id.kotlin.android.features.detail

import dagger.Module
import dagger.Provides
import id.kotlin.android.core.di.PerFeature

@Module
class DetailModule {

    @PerFeature
    @Provides
    fun providesDetailPresenter(): DetailPresenter = DetailPresenter()
}