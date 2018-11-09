package id.kotlin.android.core.executor

import io.reactivex.Scheduler

interface PostExecutionThread {

    val scheduler: Scheduler
}