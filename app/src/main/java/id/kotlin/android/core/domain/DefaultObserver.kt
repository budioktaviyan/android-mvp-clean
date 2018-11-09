package id.kotlin.android.core.domain

import io.reactivex.observers.DisposableObserver

class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onNext(t: T) {}
    override fun onError(exception: Throwable) {}
    override fun onComplete() {}
}