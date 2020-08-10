package com.sworthington.baseapplication.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitProvider @Inject constructor(private val gson: Gson) {

    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit = retrofit ?: createRetrofit()

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .also { retrofit = it }

    private fun createClient() = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    // Please note that we do not use the base URL but retrofit requires it.  We currently fully create and resolve
    // URLs for Retrofit at the service level.
    companion object {
        //TODO - base url
        private const val BASE_URL = "base url goes here"
    }
}