package id.kotlin.android.features.home

import dagger.Module
import dagger.Provides
import id.kotlin.android.core.di.PerFeature
import id.kotlin.android.core.executor.JobExecutor
import id.kotlin.android.core.executor.UIThread
import id.kotlin.android.core.ext.clazz
import retrofit2.Retrofit

@Module
class HomeModule {

    @PerFeature
    @Provides
    fun providesHomeDatasource(retrofit: Retrofit): HomeDatasource =
            retrofit.create(clazz<HomeDatasource>())

    @PerFeature
    @Provides
    fun providesHomeFactory(datasource: HomeDatasource): HomeFactory =
            HomeFactory(datasource)

    @PerFeature
    @Provides
    fun providesHomeRepository(factory: HomeFactory): HomeRepository =
            HomeRepository(factory)

    @PerFeature
    @Provides
    fun providesHomeUsecase(
            repository: HomeRepository,
            executor: JobExecutor,
            thread: UIThread
    ): HomeUsecase = HomeUsecase(repository, executor, thread)

    @PerFeature
    @Provides
    fun providesHomePresenter(usecase: HomeUsecase): HomePresenter =
            HomePresenter(usecase)
}