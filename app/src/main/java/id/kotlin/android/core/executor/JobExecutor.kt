package id.kotlin.android.core.executor

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Singleton
class JobExecutor constructor(
        private val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor
        (
                3,
                5,
                10,
                SECONDS,
                LinkedBlockingQueue(),
                JobThreadFactory()
        )
) : ThreadExecutor {

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }
}

class JobThreadFactory constructor(private var counter: Int = 0) : ThreadFactory {
    override fun newThread(r: Runnable?): Thread = Thread(r, "android_${counter.inc()}")
}