package com.yannis.hebreu.beweries.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BreweryService {
    @GET("breweries/{bewery}")
    fun getBrewery(@Path("bewery") id: Int): Observable<BreweryResponse>

    @GET("breweries")
    fun getBeweries(): Observable<List<BreweryResponse>>

    companion object {

        fun create(): BreweryService {

            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request()
                val newUrl = request.url().newBuilder().build()
                chain.proceed(request.newBuilder().url(newUrl).build())
            }.addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
                .build()


            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openbrewerydb.org/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(BreweryService::class.java)
        }
    }
}