package id.ilhamsuaib.newsmvvm.di

import id.ilhamsuaib.newsmvvm.data.remote.ApiService
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by @ilhamsuaib on 11/01/19.
 * github.com/ilhamsuaib
 */

val networkModule = module {

    single {
        val timeOut = 60L
        val apiKey = "1a4b899d7454428da0d33bc562ebd8ed"
        return@single OkHttpClient.Builder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor { chain ->
                val req = chain.request()
                    .newBuilder()
                    .addHeader("X-Api-Key", apiKey)
                    .build()
                return@addInterceptor chain.proceed(req)
            }
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    single {
        createApiService<ApiService>(get())
    }
}

inline fun <reified T> createApiService(retrofit: Retrofit): T = retrofit.create(T::class.java)
