package com.example.movies_omdb_api.di.module

import android.content.Context
import com.example.movies_omdb_api.di.ApiInfo
import com.example.movies_omdb_api.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkhttpClient(context: Context): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor(loggingInterceptor)
            .addNetworkInterceptor(Interceptor { chain ->
                var request = chain.request()

                request = if (NetworkUtils.isNetworkConnected(context))
                    request.newBuilder()
                        .header("Cache-Control", "public, max-age=" + 5)
                        .build()
                else
                    request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7)
                        .build()
                chain.proceed(request)
            })
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRestAdapter(@ApiInfo endpoint: String, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(endpoint)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}