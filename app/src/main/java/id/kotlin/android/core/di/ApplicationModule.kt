package id.kotlin.android.core.di

import dagger.Module
import dagger.Provides
import id.kotlin.android.core.executor.JobExecutor
import id.kotlin.android.core.executor.PostExecutionThread
import id.kotlin.android.core.executor.ThreadExecutor
import id.kotlin.android.core.executor.UIThread
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun providesThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun providesPostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread
}