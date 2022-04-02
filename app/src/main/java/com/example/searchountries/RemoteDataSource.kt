package com.example.searchountries

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestCoutriesApi {
    @GET("name/{name}")
    suspend fun getCountryByName(@Path("name") countryName: String): List<Country>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://countriesinfo21.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCoutriesApi = retrofit.create(RestCoutriesApi::class.java)