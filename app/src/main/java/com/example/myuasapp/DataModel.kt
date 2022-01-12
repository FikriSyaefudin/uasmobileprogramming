package com.example.myuasapp

data class DataModel (
    val jaket: List<Data>
){
    data class Data(
        val id : String?,
        val nama : String?,
        val ukuran : String?,
        val harga : String?
    )

}