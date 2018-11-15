package id.kotlin.android.core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.android.features.detail.DetailActivity
import id.kotlin.android.features.detail.DetailModule
import id.kotlin.android.features.home.HomeActivity
import id.kotlin.android.features.home.HomeModule

@Module
abstract class FeatureModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindsHomeActivity(): HomeActivity

    @PerFeature
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindsDetailActivity(): DetailActivity
}