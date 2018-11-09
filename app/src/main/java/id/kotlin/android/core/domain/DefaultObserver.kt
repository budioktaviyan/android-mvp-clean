package id.kotlin.android.core.domain

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class DefaultObserver<T> : SingleObserver<T> {

    override fun onSubscribe(disposable: Disposable) {}
    override fun onSuccess(t: T) {}
    override fun onError(exception: Throwable) {}
}