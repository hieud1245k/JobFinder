package com.hieuminh.jobfinder.APIs

import com.hieuminh.jobfinder.common.constants.UrlConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppApiClient {
    private var appRetrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (appRetrofit == null) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            appRetrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(UrlConstant.JOB_FINDER_SERVER_URL)
                .client(okHttpClient)
                .build()
        }
        return appRetrofit!!
    }

    inline fun <reified T> getService(): T {
        return getRetrofit().create(T::class.java)
    }
}
