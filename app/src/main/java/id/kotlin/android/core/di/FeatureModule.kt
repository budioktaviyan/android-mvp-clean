package id.kotlin.android.core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.android.features.detail.DetailActivity
import id.kotlin.android.features.detail.DetailModule
import id.kotlin.android.features.detail.DetailSubmodule
import id.kotlin.android.features.home.HomeActivity
import id.kotlin.android.features.home.HomeModule
import id.kotlin.android.features.home.HomeSubmodule

@Module
abstract class FeatureModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [
        HomeModule::class,
        HomeSubmodule::class
    ])
    abstract fun bindsHomeActivity(): HomeActivity

    @PerFeature
    @ContributesAndroidInjector(modules = [
        DetailModule::class,
        DetailSubmodule::class
    ])
    abstract fun bindsDetailActivity(): DetailActivity
}