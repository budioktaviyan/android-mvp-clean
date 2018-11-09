package id.kotlin.android.core.domain

import id.kotlin.android.core.executor.PostExecutionThread
import id.kotlin.android.core.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<T, Params> constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread,
        private val disposables: CompositeDisposable = CompositeDisposable()) {

    abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        val threadExecutorSchedulers: Scheduler = Schedulers.from(threadExecutor)
        val scheduler: Scheduler = postExecutionThread.scheduler
        val observable: Observable<T> = buildUseCaseObservable(params)
                .subscribeOn(threadExecutorSchedulers)
                .observeOn(scheduler)
        val disposable: Disposable = observable.subscribeWith(observer)
        addDisposable(disposable)
    }

    fun dispose() {
        disposables.clear()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}