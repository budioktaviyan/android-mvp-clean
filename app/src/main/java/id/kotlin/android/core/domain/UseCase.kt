package id.kotlin.android.core.domain

import id.kotlin.android.core.executor.PostExecutionThread
import id.kotlin.android.core.executor.ThreadExecutor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, in Params>(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    protected abstract fun buildUsecaseObservable(params: Params): Single<T>

    fun execute(singleObserver: DisposableSingleObserver<T>, params: Params) {
        val single: Single<T> = buildUsecaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(single.subscribeWith(singleObserver))
    }

    fun dispose() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}