package com.example.myuasapp.retrofit
import com.example.myuasapp.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface retrofit {
    @GET("jaket.php")
    fun data(): Call<DataModel>

}