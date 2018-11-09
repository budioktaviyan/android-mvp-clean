package id.kotlin.android.core.executor

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
            3,
            5,
            10,
            SECONDS,
            LinkedBlockingQueue(),
            JobThreadFactory()
    )

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }
}

class JobThreadFactory constructor(private var counter: Int = 0) : ThreadFactory {
    override fun newThread(runnable: Runnable?): Thread = Thread(runnable, "android_${counter.inc()}")
}