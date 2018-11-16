package id.kotlin.android.features.home

import id.kotlin.android.core.domain.Usecase
import id.kotlin.android.core.executor.JobExecutor
import id.kotlin.android.core.executor.UIThread
import io.reactivex.Single

class HomeUsecase(
        private val repository: HomeRepository,
        executor: JobExecutor,
        thread: UIThread) : Usecase<HomeEntity, HomeParam>(executor, thread) {

    override fun buildUsecaseObservable(params: HomeParam): Single<HomeEntity> =
            repository.discoverMovie(params)
}