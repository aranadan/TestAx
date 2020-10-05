package com.touchcard.testax.data.api

import com.touchcard.testax.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitBuilder {
    private const val CONNECT_TIMEOUT = 60L
    private const val READ_TIMEOUT = 60L
    private const val BASE_URL = "https://randomuser.me/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideHttpClient(): OkHttpClient {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val okHttpClientBuilder =
            OkHttpClient
                .Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpInterceptor)
                .addInterceptor {
                    it.run {
                        proceed(
                            request()
                                .newBuilder()
                                .header("accept", "application/json")
                                .build()
                        )
                    }
                }
        return okHttpClientBuilder.build()
    }

    internal val apiService: ApiService =
        getRetrofit().create(ApiService::class.java)
}