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

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesHttpClient(): OkHttpClient =
            OkHttpClient.Builder().apply {
                connectTimeout(30, SECONDS)
                readTimeout(15, SECONDS)
                writeTimeout(15, SECONDS)
                retryOnConnectionFailure(true)
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