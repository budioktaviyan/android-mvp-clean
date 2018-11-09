package id.kotlin.android.core.di

import dagger.Module
import dagger.Provides
import id.kotlin.android.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

object HttpClientConfig {

    const val CONNECT_TIMEOUT: Long = 30
    const val READ_TIMEOUT: Long = 15
    const val WRITE_TIMEOUT: Long = 15
    const val RETRY_CONNECTION_FAILURE = true
}

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesHttpClient(): OkHttpClient =
            OkHttpClient.Builder().apply {
                connectTimeout(HttpClientConfig.CONNECT_TIMEOUT, SECONDS)
                readTimeout(HttpClientConfig.READ_TIMEOUT, SECONDS)
                writeTimeout(HttpClientConfig.WRITE_TIMEOUT, SECONDS)
                retryOnConnectionFailure(HttpClientConfig.RETRY_CONNECTION_FAILURE)
            }.build()

    @Provides
    @Singleton
    fun providesHttpAdapter(httpClient: OkHttpClient): Retrofit =
            Retrofit.Builder().apply {
                client(httpClient)
                baseUrl(BASE_URL)
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                addConverterFactory(GsonConverterFactory.create())
            }.build()
}