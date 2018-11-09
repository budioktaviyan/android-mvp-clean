package id.kotlin.android.features.home

import id.kotlin.android.core.domain.UseCase
import id.kotlin.android.core.executor.JobExecutor
import id.kotlin.android.core.executor.UIThread
import io.reactivex.Single

class HomeUsecase(
        private val repository: HomeRepository,
        executor: JobExecutor,
        thread: UIThread) : UseCase<HomeEntity, HomeParam>(executor, thread) {

    override fun buildUsecaseObservable(params: HomeParam): Single<HomeEntity> =
            repository.discoverMovie(params)
}