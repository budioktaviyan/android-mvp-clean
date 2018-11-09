package id.kotlin.android.core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.android.features.home.HomeActivity
import id.kotlin.android.features.home.HomeModule

@Module
abstract class FeatureModule {

    @PerFeature
    @ContributesAndroidInjector(modules = [HomeModule::class])
    @Suppress
    abstract fun bindHomeActivity(): HomeActivity
}