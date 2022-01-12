package com.example.myuasapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.google.gson.GsonBuilder

import com.google.gson.Gson

class api {

    val endpoint: retrofit
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit1 = Retrofit.Builder()
                .baseUrl("http://192.168.43.101/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit1.create(retrofit::class.java)
        }


}