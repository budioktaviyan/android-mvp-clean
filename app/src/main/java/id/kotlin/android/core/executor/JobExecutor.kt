package id.kotlin.android.core.executor

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

object JobExecutorConfig {

    const val MIN_POOL_SIZE = 3
    const val MAX_POOL_SIZE = 5
    const val KEEP_ALIVE_TIME: Long = 10
}

interface ThreadExecutor : Executor

class JobExecutor @Inject constructor() : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
            JobExecutorConfig.MIN_POOL_SIZE,
            JobExecutorConfig.MAX_POOL_SIZE,
            JobExecutorConfig.KEEP_ALIVE_TIME,
            SECONDS,
            LinkedBlockingQueue(),
            JobThreadFactory()
    )

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }
}

class JobThreadFactory(private var counter: Int = 0) : ThreadFactory {

    override fun newThread(runnable: Runnable?): Thread = Thread(
            runnable, "android_${counter.inc()}"
    )
}